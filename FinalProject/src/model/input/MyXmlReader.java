package model.input;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Util class to read Xml files of specific format
 */
public class MyXmlReader {

    private static File file;
    private static JAXBContext context;
    private static Unmarshaller unmarshaller;

    public static Products readProducts(String path) throws JAXBException {
        file = new File(path);
        context = JAXBContext.newInstance(Products.class, Product.class);
        unmarshaller = context.createUnmarshaller();

        return (Products) unmarshaller.unmarshal(file);
    }

    public static Sellers readSellers(String path) throws JAXBException {
        file = new File(path);
        context = JAXBContext.newInstance(Sellers.class, Seller.class);
        unmarshaller = context.createUnmarshaller();

        return (Sellers) unmarshaller.unmarshal(file);
    }

    public static SellersProducts readSellersProducts(String path) throws JAXBException {
        file = new File(path);
        context = JAXBContext.newInstance(SellersProducts.class, SellersProduct.class);
        unmarshaller = context.createUnmarshaller();

        return (SellersProducts) unmarshaller.unmarshal(file);
    }

    public static Sales readSales(String path) throws JAXBException {
        file = new File(path);
        context = JAXBContext.newInstance(Sales.class, Sale.class);
        unmarshaller = context.createUnmarshaller();

        return (Sales) unmarshaller.unmarshal(file);
    }

}
