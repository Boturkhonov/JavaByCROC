package model.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Represent the collection of sale
 */
@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sales {

    @XmlElement(name = "sale")
    private List<Sale> sales = null;

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
