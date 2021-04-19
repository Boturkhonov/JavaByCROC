package model.input;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Seller getSeller(int id) {

        Optional<Seller> first = sellers.stream()
                .filter(seller -> seller.getId() == id)
                .findFirst();

        if (first.isPresent())
            return first.get();
        else throw new NoSuchElementException("Продавец с id = " + id);
    }
}
