package controller;

import model.input.*;
import model.output.MyJsonWriter;
import view.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static model.MyStorage.*;

/**
 * Class to manage everything that happens in UI
 */
public class Controller implements ActionListener {

    private static final String FIRST_TASK_OUTPUT = "output\\cheapProducts.json";
    private static final String  SECOND_TASK_OUTPUT = "output\\popularDates.json";

    private final MainFrame mainFrame;
    private String lastOpenedPath = ".";


    /**
     * @param mainFrame JFrame object to take care of
     */
    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * Hangs listeners to the elements of the given {@code JFrame} object
     * The frame is deaf unless you call this method
     */
    public void execute() {

        for (int i = 0; i < mainFrame.getOpenMenu().getItemCount(); i++) {
            mainFrame.getOpenMenu().getItem(i).addActionListener(this);
        }

        mainFrame.getExit().addActionListener(this);

        for (int i = 0; i < mainFrame.getTaskMenu().getItemCount(); i++) {
            mainFrame.getTaskMenu().getItem(i).addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String className = e.getSource().getClass().getName();
        if (className.equals("javax.swing.JMenuItem")) {
            menuActionHandler(e);
        }
    }

    private void menuActionHandler(ActionEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        for (int i = 0; i < mainFrame.getOpenMenu().getItemCount(); i++) {
            if (source == mainFrame.getOpenMenu().getItem(i)) {
                fileChooserMenu(mainFrame.getOpenMenu().getItem(i).getText());
                return;
            }
        }
        if (source == mainFrame.getExit()) {
            exitProgram();
        } else if (source == mainFrame.getTaskMenu().getItem(0)) {
            firstTask();
        } else if (source == mainFrame.getTaskMenu().getItem(1)) {
            secondTask();
        }
    }

    /**
     * Solves first task and writes the result to file
     */
    private void firstTask() {
        if (products == null || products.getProducts() == null ||
                sellers == null || sellers.getSellers() == null ||
                sellersProducts == null || sellersProducts.getSellersProducts() == null) {
            showExceptionMessage("Некоторые таблицы не заполнены");
            return;
        }

        try {
            MyJsonWriter.writeCheapProducts(Solver.findCheapProducts(), FIRST_TASK_OUTPUT);
            showSuccessMessage("Результат успешно записан в " + FIRST_TASK_OUTPUT);
        } catch (IOException e) {
            showExceptionMessage("Невозможно записать результат");
        }

    }

    /**
     * Solves second task and writes result to file
     */
    private void secondTask() {
        if (sales == null || sales.getSales() == null) {
            showExceptionMessage("Некоторые таблицы не заполнены");
            return;
        }
        try {
            MyJsonWriter.writePopularDates(Solver.findPopularDates(), SECOND_TASK_OUTPUT);
            showSuccessMessage("Результат успешно записан в " + SECOND_TASK_OUTPUT);
        } catch (IOException e) {
            showExceptionMessage("Невозможно записать результат");
        }
    }

    /**
     * Terminates the program
     */
    private void exitProgram() {
        mainFrame.dispose();
    }

    private void fileChooserMenu(String tableType) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(lastOpenedPath));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML-файл", "xml"));
        fileChooser.setAcceptAllFileFilterUsed(false);

        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            lastOpenedPath = fileChooser.getSelectedFile().getPath();

            parseFile(lastOpenedPath, tableType);

        }

    }

    /**
     * Reads and parses XMl file and according to the tableType chooses which table to fill
     *
     * @param path the path of chosen XML file
     */
    private void parseFile(String path, String tableType) {
        try {
            if (tableType.equals(mainFrame.getOpenMenu().getItem(0).getText())) {
                products = MyXmlReader.readProducts(path);
                fillProductTable(products.getProducts());
            } else if (tableType.equals(mainFrame.getOpenMenu().getItem(1).getText())) {
                sellers = MyXmlReader.readSellers(path);
                fillSellerTable(sellers.getSellers());
            } else if (tableType.equals(mainFrame.getOpenMenu().getItem(2).getText())) {
                sellersProducts = MyXmlReader.readSellersProducts(path);
                fillSellersProductTable(sellersProducts.getSellersProducts());
            } else if (tableType.equals(mainFrame.getOpenMenu().getItem(3).getText())) {
                sales = MyXmlReader.readSales(path);
                fillSaleTable(sales.getSales());
            }
        } catch (JAXBException e) {
            String[] split = path.split("\\\\");
            showExceptionMessage("Невозможно прочитать файл " + split[split.length-1]);
        } catch (NullPointerException e) {
            showExceptionMessage("Сначала заполните таблицы товаров и продавцов");
        } catch (NoSuchElementException e) {
            showExceptionMessage(e.getMessage() + " не существует");
        } catch (Exception e) {
            showExceptionMessage("Something really went wrong");
            e.printStackTrace();
        }
    }


    /**
     * Fills the table of products with given list of products
     */
    private void fillProductTable(List<Product> products) {
        DefaultTableModel tableModel = mainFrame.getProductTableModel();

        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        for (Product product : products) {
            Object[] row = new Object[]{
                    product.getId(),
                    product.getName()
            };
            tableModel.addRow(row);
        }

    }

    /**
     * Fills the table of sellers with given list of seller
     */
    private void fillSellerTable(List<Seller> sellers) {
        DefaultTableModel tableModel = mainFrame.getSellerTableModel();

        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        for (Seller seller : sellers) {
            Object[] row = new Object[]{
                    seller.getId(),
                    seller.getFirstName(),
                    seller.getLastName()
            };
            tableModel.addRow(row);
        }
    }

    /**
     * Fills the table of sellers' products with given list
     */
    private void fillSellersProductTable(List<SellersProduct> sellersProducts) {
        DefaultTableModel tableModel = mainFrame.getSellersProductTableModel();

        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        for (SellersProduct sellersProduct : sellersProducts) {
            Object[] row = new Object[]{
                    sellersProduct.getSellerId(),
                    sellersProduct.getProductId(),
                    sellersProduct.getPrice(),
                    sellersProduct.getQuantity()
            };
            tableModel.addRow(row);
        }
    }


    /**
     * Fills the table of sales with given list of sale
     */
    private void fillSaleTable(List<Sale> sales) {
        DefaultTableModel tableModel = mainFrame.getSaleTableModel();

        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        for (Sale sale : sales) {
            Object[] row = new Object[]{
                    sale.getSaleId(),
                    sale.getSellerId(),
                    sale.getProductId(),
                    sale.getQuantity(),
                    sale.getSoldDate()
            };
            tableModel.addRow(row);
        }
    }

    /**
     * Shows error dialog window with given {@code message}
     *
     * @param message text to show
     */
    private void showExceptionMessage(String message) {
        JOptionPane.showMessageDialog(mainFrame, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    private void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(mainFrame, message, "Выполнено", JOptionPane.INFORMATION_MESSAGE);
    }
}
