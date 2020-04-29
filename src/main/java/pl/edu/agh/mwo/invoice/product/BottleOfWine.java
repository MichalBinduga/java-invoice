package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class BottleOfWine extends Product {

    private BigDecimal excise = new BigDecimal("5.56");

    public BigDecimal getExcise() {
        return excise;
    }

    public BottleOfWine(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.19"));
    }

    public BigDecimal getPriceWithTax() {
        return super.getPriceWithTax().add(excise);
    }
}