package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
		if (name == null) {
			throw new IllegalArgumentException("Trzeba podac nazwe");
		}
		if (price == null) {
			throw new IllegalArgumentException("Trzeba podac cene");			
		//}else if (price.)) {
			
		}
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return this.price.add(this.taxPercent.multiply(this.price));
	}
}
