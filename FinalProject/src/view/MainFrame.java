package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * User interface class
 */
public class MainFrame extends JFrame {

    private JMenuBar menuBar;
    private JMenu openMenu;
    private JMenu taskMenu;
    private JMenuItem exit;

    private DefaultTableModel productTableModel;
    private DefaultTableModel sellerTableModel;
    private DefaultTableModel sellersProductTableModel;
    private DefaultTableModel saleTableModel;

    public JMenuBar menuBar() {
        return menuBar;
    }

    public JMenu getOpenMenu() {
        return openMenu;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public JMenu getTaskMenu() {
        return taskMenu;
    }

    public DefaultTableModel getProductTableModel() {
        return productTableModel;
    }

    public DefaultTableModel getSellerTableModel() {
        return sellerTableModel;
    }

    public DefaultTableModel getSellersProductTableModel() {
        return sellersProductTableModel;
    }

    public DefaultTableModel getSaleTableModel() {
        return saleTableModel;
    }


    public MainFrame() {
        setUpWindow();
        setUpMenuBar();
        setUpTabs();

        this.setVisible(true);
    }

    private void setUpWindow() {
        this.setTitle("Учёт");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 530);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        ImageIcon imageIcon = new ImageIcon("images/logo.png");
        this.setIconImage(imageIcon.getImage());

    }

    private void setUpMenuBar() {
        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);

        openMenu = new JMenu("Открыть...");
        openMenu.add(new JMenuItem("Товары"));
        openMenu.add(new JMenuItem("Продавцы"));
        openMenu.add(new JMenuItem("Товары у продовцов"));
        openMenu.add(new JMenuItem("Продажа"));
        fileMenu.add(openMenu);
        openMenu.setIcon(new ImageIcon("images/open-icon.png"));

        exit = new JMenuItem("Выход");
        fileMenu.add(exit);
        exit.setIcon(new ImageIcon("images/exit-icon.png"));

        taskMenu = new JMenu("Задания");
        taskMenu.add(new JMenuItem("Задание 1"));
        taskMenu.add(new JMenuItem("Задание 2"));
        menuBar.add(taskMenu);

        this.setJMenuBar(menuBar);
    }

    private void setUpTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel productPanel = new JPanel();
        JPanel sellerPanel = new JPanel();
        JPanel sellersProductPanel = new JPanel();
        JPanel salePanel = new JPanel();


        // -----------------------------Product tab-------------------------------------------------
        tabbedPane.addTab("Товары", productPanel);

        productTableModel = new DefaultTableModel();

        JTable productTable = new JTable(productTableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] columns = {
                "ID товара",
                "Наименование товара"
        };

        for (String column : columns) {
            productTableModel.addColumn(column);
        }
        productTableModel.setRowCount(1);

        productPanel.add(new JScrollPane(productTable));

        // ------------------------------Seller tab-------------------------------------------------
        tabbedPane.addTab("Продавцы", sellerPanel);

        sellerTableModel = new DefaultTableModel();

        JTable sellerTable = new JTable(sellerTableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        columns = new String[]{
                "ID продавца",
                "Фамилия продавца",
                "Имя продавца"
        };
        for (String column : columns) {
            sellerTableModel.addColumn(column);
        }

        sellerPanel.add(new JScrollPane(sellerTable));

        // ------------------------------Sellers product tab----------------------------------------
        tabbedPane.addTab("Товары у продовцов", sellersProductPanel);

        sellersProductTableModel = new DefaultTableModel();

        JTable sellersProductTable = new JTable(sellersProductTableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        columns = new String[]{
                "ID продавца",
                "ID товара",
                "Цена товара",
                "Кол-во товара"
        };

        for (String column : columns) {
            sellersProductTableModel.addColumn(column);
        }

        sellersProductPanel.add(new JScrollPane(sellersProductTable));

        // ----------------------------------Sale tab-----------------------------------------------
        tabbedPane.addTab("Продажы", salePanel);

        saleTableModel = new DefaultTableModel();

        JTable saleTable = new JTable(saleTableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        columns = new String[]{
                "ID продажи",
                "ID продавца",
                "ID товара",
                "Количество проданных товаров",
                "Дата продажи"
        };
        for (String column : columns) {
            saleTableModel.addColumn(column);
        }
        salePanel.add(new JScrollPane(saleTable));

        this.add(tabbedPane, BorderLayout.CENTER);
    }

}
