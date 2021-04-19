package model.input;

import model.MyStorage;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "sellers_product")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SellersProduct {

    private Seller seller;
    private Product product;
    private double price;
    private int quantity;

    @XmlElement(name = "seller_id")
    public int getSellerId() {
        return seller.getId();
    }
    public void setSellerId(int sellerId) throws NullPointerException {
        this.seller = MyStorage.sellers.getSeller(sellerId);
    }

    @XmlElement(name = "product_id")
    public int getProductId() {
        return product.getId();
    }
    public void setProductId(int productId)throws NullPointerException {
        this.product = MyStorage.products.getProduct(productId);
    }

    // Default Getters & Setters

    public Seller getSeller() {
        return seller;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
