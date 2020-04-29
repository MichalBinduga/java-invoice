package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuelCanister extends BottleOfWine {

    private LocalDate today = LocalDate.now();
    private final LocalDate transportDay = LocalDate.of(2020, 04, 26);

    public FuelCanister(String name, BigDecimal price) {
        super(name, price);
    }

    public BigDecimal getPriceWithTax() {
        if (today.equals(transportDay)) {
            return getPrice().add(getExcise());
        } else {
            return super.getPriceWithTax();
        }
    }
}