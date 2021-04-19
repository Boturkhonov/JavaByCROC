package model.input;

import model.MyStorage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Model class of sale
 */
@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Sale {

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private int saleId;
    private Seller seller;
    private Product product;
    private int quantity;
    private LocalDate soldDate;


    private Sale() {}

    @XmlElement(name = "seller_id")
    public int getSellerId() {
        return seller.getId();
    }
    public void setSellerId(int sellerId) {
        seller = MyStorage.sellers.getSeller(sellerId);
    }

    @XmlElement(name = "product_id")
    public int getProductId() {
        return product.getId();
    }
    public void setProductId(int sellerId) {
        product = MyStorage.products.getProduct(sellerId);
    }


    public Seller getSeller() {
        return seller;
    }

    public Product getProduct() {
        return product;
    }

    @XmlElement(name = "sale_id")
    public int getSaleId() {
        return saleId;
    }
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlElement(name = "sold_date")
    public void setSoldDate(String date) {
        soldDate = LocalDate.parse(date, DATE_FORMAT);
    }
    public String getSoldDate() {
        return soldDate.format(DATE_FORMAT);
    }
}
