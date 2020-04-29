package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<>();
    private static int nextNumber = 0;
    private final int number = ++nextNumber;

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        } else {
            products.put(product, quantity);
        }
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

    public int getNumber() {
        return number;
    }

    public void print() {
        System.out.println("Faktura numer: " + number);
        System.out.printf("%-40s %-40s %-40s\n", 
                "Nazwa produktu:", 
                "Ilość:", 
                "Cena jednej sztuki:");
        for (Product product : products.keySet()) {
            System.out.printf("%-40s %-40s %-40s\n", product.toStringName(), products.get(product),
                    product.getPriceWithTax());
        }
        System.out.println("Liczba pozycji na fakturze: " + products.size() + "\n");
    }
}
