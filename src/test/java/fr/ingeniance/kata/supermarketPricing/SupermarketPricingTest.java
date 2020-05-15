/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import fr.ingeniance.kata.supermarketPricing.model.Product;
import fr.ingeniance.kata.supermarketPricing.utils.IllegalUnitException;
import fr.ingeniance.kata.supermarketPricing.utils.UnitEnum;

/**
 * @author SAAIDI
 *
 */
public class SupermarketPricingTest {

	@Test
	public void productWithDiscount() throws IllegalUnitException {
		// buy 5 product A without discount
		// unit price = 1
		Product product = new Product("A", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.totalPrice(product);
		Assert.assertEquals(new BigDecimal("5.000"),totalPrice);
	}
	
	@Test
	public void productWithBuy2AndGet1Discount() throws IllegalUnitException {
		// buy 5 product B With Discount (buy 2 and get 1)
		// unit price = 1
		// buy 2 and get 1 free + buy the rest without discount
		Product product = new Product("B", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.totalPrice(product);
		Assert.assertEquals(new BigDecimal("4.000"),totalPrice);
	}
	
	@Test
	public void productWithBuy3AndGet2Discount() throws IllegalUnitException {
		// buy 5 product BB With Discount (buy 3 and get 2)
		// unit price = 1
		// buy 3 and get 2 free 
		Product product = new Product("BB", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.totalPrice(product);
		Assert.assertEquals(new BigDecimal("3.000"),totalPrice);
	}
	
	@Test
	public void productWithGet3For1DollarDiscount() throws IllegalUnitException {
		// buy 5 product C With Discount (buy 3 for 1 dollar)
		// unit price = 1
		// buy 3 for 1 dollar and 2 for 1 dollar/unit 
		Product product = new Product("C", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.totalPrice(product);
		Assert.assertEquals(new BigDecimal("3.000"),totalPrice);
	}
	
	@Test
	public void productWithGet5For399DollarDiscount() throws IllegalUnitException {
		// buy 5 product CC With Discount (buy 5 for 3.99 dollar)
		// unit price = 1
		// buy 5 for 3.99 dollar
		Product product = new Product("CC", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.totalPrice(product);
		Assert.assertEquals(new BigDecimal("3.990"),totalPrice);
	}
	
	@Test
	public void productWithChangePoundToOunce() throws IllegalUnitException {
		// Product D : 1.99/pound 
		// buy 4 ounces for 0.498
		Product product = new Product("D", new BigDecimal("4.0"), UnitEnum.OUNCE);
		BigDecimal totalPrice = SupermarketPricing.totalPrice(product);
		Assert.assertEquals(new BigDecimal("0.498"),totalPrice);
	}
	
	@Test
	public void productWithChangeOunceToPound() throws IllegalUnitException {
		// Product DD : 0.25/ounce 
		// buy 1 pound for 4 dollars
		Product product = new Product("DD", new BigDecimal("1.0"), UnitEnum.POUND);
		BigDecimal totalPrice = SupermarketPricing.totalPrice(product);
		Assert.assertEquals(new BigDecimal("4.000"),totalPrice);
	}
	
	@Test
	public void productWithUnitException() {
		// try to buy 5 units of product D calculated by pound or ounce
		Product productA = new Product("D", new BigDecimal("5.0"), UnitEnum.UNIT);
		try {
			SupermarketPricing.totalPrice(productA);
			Assert.assertTrue(false);
		} catch (IllegalUnitException e) {
			Assert.assertTrue(true);
		}
	}


}
