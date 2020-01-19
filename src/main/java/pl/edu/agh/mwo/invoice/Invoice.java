package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Map <Product, Integer> products = new HashMap<>();

	public void addProduct(Product product) {
		this.addProduct(product,1);
	}

	public void addProduct(Product product, Integer quantity) {
		this.products.put(product,quantity);
		if (quantity <0 || quantity == 0) {
			throw new IllegalArgumentException("Ilosc nie może być ujemna ani wynosić 0");
		}
	}

	public BigDecimal getNetPrice() {
		if (products == null ) {
			return BigDecimal.ZERO;
		}
		BigDecimal sumaNetto = BigDecimal.ZERO;
		for (Product product : this.products.keySet()){
			Integer quantinty = this.products.get(product);
			sumaNetto = sumaNetto.add(product.getPrice().multiply(new BigDecimal(quantinty)));
		}
		return sumaNetto;
	}

	public BigDecimal getTax() {
		if (products == null) {
			return BigDecimal.ZERO;
		}
		return this.getGrossPrice().subtract(this.getNetPrice());
	}

	public BigDecimal getGrossPrice() {
		if (products == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal sumaBrutto = BigDecimal.ZERO;
		for (Product product : this.products.keySet()){
			Integer quantinty = this.products.get(product);
			sumaBrutto = sumaBrutto.add(product.getPriceWithTax().multiply(new BigDecimal(quantinty)));
		}
		return sumaBrutto;
	}
}
