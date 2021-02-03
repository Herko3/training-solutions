package week14.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ShopManager {

    public static final String SEPARATOR = ": ";
    public static final String ID_SEPARATOR = "-";
    public static final String PRODUCT_SEPARATOR = ",";
    public static final String PRICE_START = "(";
    public static final String PRICE_END = ")";

    Map<String, List<Shopping>> map = new HashMap<>();

    public void readFile(BufferedReader reader) {
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(SEPARATOR);
                String[] id = parts[0].split(ID_SEPARATOR);
                String shopperID = id[0];
                String shopID = id[1];
                List<Product> products = getProducts(parts[1].split(PRODUCT_SEPARATOR));
                mapping(shopperID, new Shopping(shopID, products));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void mapping(String shopperID, Shopping toPut) {
        if (!map.containsKey(shopperID)) {
            map.put(shopperID, new ArrayList<>());
        }
        map.get(shopperID).add(toPut);
    }

    private List<Product> getProducts(String[] shopping) {
        List<Product> products = new ArrayList<>();
        for (String s : shopping) {
            String product = s.substring(0, s.indexOf(PRICE_START));
            String price = s.substring(s.indexOf(PRICE_START) + 1, s.indexOf(PRICE_END));
            products.add(new Product(product, Integer.parseInt(price)));
        }
        return products;
    }

    public int getPriceById(String id) {
        return map.values().stream().flatMap(Collection::stream).filter(s->s.getId().equals(id)).reduce(0,(i, s) -> i + s.sumPrice(), Integer::sum);
//        for (Map.Entry<String, List<Shopping>> entry : map.entrySet()) {
//            for (Shopping shopping : entry.getValue()) {
//                if (shopping.getId().equals(id)) {
//                    return shopping.sumPrice();
//                }
//            }
//        }
//        throw new IllegalArgumentException("No data");
    }

    public int getPriceByShopper(String shopperId) {
        List<Shopping> shopping = map.get(shopperId);
        return shopping.stream().reduce(0, (i, s) -> i + s.sumPrice(), Integer::sum);
    }

    public List<Product> sortedBy(String name, String shopId, Comparator<Product> comp) {
        return map.get(name).stream().filter(s -> s.getId().equals(shopId)).map(Shopping::getProducts).flatMap(l -> l.stream().sorted(comp)).collect(Collectors.toList());
//        List<Product> result;
//        for (Shopping shopping : map.get(name)) {
//            if (shopping.getId().equals(shopId)) {
//                result = new ArrayList<>(shopping.getProducts());
//                result.sort(comp);
//                return result;
//            }
//        }
//        throw new IllegalArgumentException("No data");
    }

    public int numberBought(String name) {
        return statistics().get(name).intValue();
    }

    public Map<String, Long> statistics() {
        return map.values().stream().flatMap(Collection::stream).map(Shopping::getProducts).flatMap(l->l.stream()).collect(Collectors.groupingBy(Product::getName,Collectors.counting()));

//        Map<String, Integer> result = new HashMap<>();
//        for (Map.Entry<String, List<Shopping>> entry : map.entrySet()) {
//            for (Shopping shopping : entry.getValue()) {
//                for (Product product : shopping.getProducts()) {
//                    if (!result.containsKey(product.getName())) {
//                        result.put(product.getName(), 1);
//                    } else {
//                        int sum = result.get(product.getName()) + 1;
//                        result.put(product.getName(), sum);
//                    }
//                }
//            }
//        }
//        return result;
    }
}
