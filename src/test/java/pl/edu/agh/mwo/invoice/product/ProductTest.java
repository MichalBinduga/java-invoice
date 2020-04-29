package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import pl.edu.agh.mwo.invoice.product.Product;

public class ProductTest {
	@Test
	public void testProductNameIsCorrect() {
		Product product = new OtherProduct("buty", new BigDecimal("100.0"));
		Assert.assertEquals("buty", product.getName());
	}

	@Test
	public void testProductPriceAndTaxWithDefaultTax() {
		Product product = new OtherProduct("Ogorki", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("100"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("0.23"), Matchers.comparesEqualTo(product.getTaxPercent()));
	}

	@Test
	public void testProductPriceAndTaxWithDairyProduct() {
		Product product = new DairyProduct("Szarlotka", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("100"), Matchers.comparesEqualTo(product.getPrice()));
		Assert.assertThat(new BigDecimal("0.08"), Matchers.comparesEqualTo(product.getTaxPercent()));
	}

	@Test
	public void testPriceWithTax() {
		Product product = new DairyProduct("Oscypek", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("108"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNullName() {
		new OtherProduct(null, new BigDecimal("100.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithEmptyName() {
		new TaxFreeProduct("", new BigDecimal("100.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNullPrice() {
		new DairyProduct("Banany", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductWithNegativePrice() {
		new TaxFreeProduct("Mandarynki", new BigDecimal("-1.00"));
	}

	@Test
	public void testPriceWithExcise() {
		Product product = new BottleOfWine("Wino", new BigDecimal("10.0"));
		Assert.assertThat(new BigDecimal("17.46"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}

	@Test
	public void testFuelPriceWithExcise() {
		Product product = new FuelCanister("ON", new BigDecimal("1.0"));
		Assert.assertThat(new BigDecimal("6.75"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}

	@Test
	public void testFuelPriceWithoutExcise() {
		Product product = new FuelCanister("ON", new BigDecimal("1.0"));
		Assert.assertThat(new BigDecimal("6.59"), Matchers.comparesEqualTo(product.getPriceWithTax()));
	}

	@Test
	public void testWineName() {
		BottleOfWine product = new BottleOfWine("Wino", new BigDecimal("100.0"));
		Assert.assertThat(new BigDecimal("5.56"), Matchers.comparesEqualTo(product.getExcise()));
	}
}
