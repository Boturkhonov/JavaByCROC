package model.input;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Represents the collection of Seller
 */
@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sellers {

    @XmlElement(name = "seller")
    private List<Seller> sellers = null;

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    /**
     * Searches the Seller list in {@link model.MyStorage} and finds seller with given {@code id}
     * @param id the Seller's id
     * @return Seller with given {@code id}
     * @throws NoSuchElementException if seller with given id does not exist
     */
    public Seller getSeller(int id) {

        Optional<Seller> first = sellers.stream()
                .filter(seller -> seller.getId() == id)
                .findFirst();

        if (first.isPresent())
            return first.get();
        else throw new NoSuchElementException("Продавец с id = " + id);
    }
}
