package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import pl.edu.agh.mwo.invoice.product.BottleOfWine;
import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.FuelCanister;
import pl.edu.agh.mwo.invoice.product.Product;

public class Demo {
    public static void main(String[] args) {
        Product prod1 = new Product("Chleb", new BigDecimal("3"), new BigDecimal("0.2")){
        };
        Product prod2 = new DairyProduct("Mleko", new BigDecimal("2"));
        Product prod3 = new BottleOfWine("Wino", new BigDecimal("10"));
        Product prod4 = new FuelCanister("PB95", new BigDecimal("1"));

        Invoice faktura = new Invoice();
        faktura.addProduct(prod3);
        faktura.addProduct(prod2);
        faktura.addProduct(prod3, 2);
        faktura.addProduct(prod4);
        faktura.addProduct(prod1, 2);
        faktura.print();
    }
}