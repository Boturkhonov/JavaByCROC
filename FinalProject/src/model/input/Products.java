package model.input;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Represents the collection of products
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {

    @XmlElement(name = "product")
    private List<Product> products = null;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @param id id of product
     * @return product with given {@code id}
     */
    public Product getProduct(int id) {
        Optional<Product> first = products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
        if (first.isPresent())
            return first.get();
        else throw new NoSuchElementException("Товар с id = " + id);
    }

}
