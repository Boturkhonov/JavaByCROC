package controller;

import model.input.Product;
import model.input.Sale;
import model.input.SellersProduct;
import model.output.CheapProduct;

import java.util.*;
import java.util.stream.Collectors;

import static model.MyStorage.*;

/**
 * Util class to solve tasks
 */
public class Solver {

    /**
     * For each Product in {@code model.MyStorage.products} finds the seller with the cheapest price for that product
     * @return list of cheap products
     */
    public static List<CheapProduct> findCheapProducts() {

        List<CheapProduct> cheapList = new ArrayList<>();
        for (Product product : products.getProducts()) {

            Optional<SellersProduct> min = sellersProducts.getSellersProducts().stream()
                    .filter(p -> p.getProductId() == product.getId())
                    .min(Comparator.comparingDouble(SellersProduct::getPrice));

            if (min.isPresent()) {
                SellersProduct sellersProduct = min.get();
                CheapProduct cheapProduct = new CheapProduct();
                cheapProduct.setProductName(sellersProduct.getProduct().getName());
                cheapProduct.setSellerName(sellersProduct.getSeller().getFirstName() + " " + sellersProduct.getSeller().getLastName());
                cheapProduct.setPrice(sellersProduct.getPrice());
                cheapList.add(cheapProduct);
            }

        }

        return cheapList;
    }

    /**
     * @return  Top five dates with the most sold products as a Map &lt;String, Integer&gt; where String represents date, and Integer -  sum of sold products
     */
    public static Map<String, Integer> findPopularDates() {

        // For each day, counting the sum of all sold products, and saving as map of <date, sumOfSoldProducts>
        Map<String, Integer> map = new HashMap<>();
        for (Sale sale : sales.getSales()) {
            String date = sale.getSoldDate();
            Integer soldAmount = sale.getQuantity();

            if (map.containsKey(date)) {
                map.put(date, map.get(date) + soldAmount);
            } else {
                map.put(date, soldAmount);
            }
        }

        // Sorting and extracting top 5 date with most sold products
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
