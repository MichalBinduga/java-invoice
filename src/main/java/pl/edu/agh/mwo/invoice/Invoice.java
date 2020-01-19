package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products;

	public void addProduct(Product product) {
		// TODO: implement
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity <0 || quantity == 0) {
			throw new IllegalArgumentException("Ilosc nie może być ujemna ani wynosić 0");
		}
	}

	public BigDecimal getSubtotal() {
		if (products == null ) {
			return BigDecimal.ZERO;
		}
		return null;
	}

	public BigDecimal getTax() {
		if (products == null) {
			return BigDecimal.ZERO;
		}
		return null;
	}

	public BigDecimal getTotal() {
		if (products == null) {
			return BigDecimal.ZERO;
		}
		return null;
	}
}
