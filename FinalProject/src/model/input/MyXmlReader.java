package model.input;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Util class to read Xml files of specific format
 */
public class MyXmlReader {

    // Paths to xsd files used for validating xml files
    private static final String PRODUCTS_XSD = "xsd/Products.xsd";
    private static final String SELLERS_XSD = "xsd/Sellers.xsd";
    private static final String SELLERS_PRODUCTS_XSD = "xsd/SellersProducts.xsd";
    private static final String SALES_XSD = "xsd/Sales.xsd";
    private static final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    private static Schema schema;

    // a file to read from
    private static File file;
    private static JAXBContext context;
    private static Unmarshaller unmarshaller;

    public static Products readProducts(String path) throws JAXBException, SAXException {
        file = new File(path);
        context = JAXBContext.newInstance(Products.class, Product.class);
        unmarshaller = context.createUnmarshaller();

        schema = schemaFactory.newSchema(new File(PRODUCTS_XSD));
        unmarshaller.setSchema(schema);

        return (Products) unmarshaller.unmarshal(file);
    }

    public static Sellers readSellers(String path) throws JAXBException, SAXException {
        file = new File(path);
        context = JAXBContext.newInstance(Sellers.class, Seller.class);
        unmarshaller = context.createUnmarshaller();

        schema = schemaFactory.newSchema(new File(SELLERS_XSD));
        unmarshaller.setSchema(schema);

        return (Sellers) unmarshaller.unmarshal(file);
    }

    public static SellersProducts readSellersProducts(String path) throws JAXBException, SAXException {
        file = new File(path);
        context = JAXBContext.newInstance(SellersProducts.class, SellersProduct.class);
        unmarshaller = context.createUnmarshaller();

        schema = schemaFactory.newSchema(new File(SELLERS_PRODUCTS_XSD));
        unmarshaller.setSchema(schema);

        return (SellersProducts) unmarshaller.unmarshal(file);
    }

    public static Sales readSales(String path) throws JAXBException, SAXException {
        file = new File(path);
        context = JAXBContext.newInstance(Sales.class, Sale.class);
        unmarshaller = context.createUnmarshaller();

        schema = schemaFactory.newSchema(new File(SALES_XSD));
        unmarshaller.setSchema(schema);

        return (Sales) unmarshaller.unmarshal(file);
    }

}
