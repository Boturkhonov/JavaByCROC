package model.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Represents the collection of SellerProducts
 */
@XmlRootElement(name = "sellers_products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellersProducts {

    @XmlElement(name = "sellers_product")
    List<SellersProduct> sellersProducts = null;

    public List<SellersProduct> getSellersProducts() {
        return sellersProducts;
    }

    public void setSellersProducts(List<SellersProduct> sellersProducts) {
        this.sellersProducts = sellersProducts;
    }
}
