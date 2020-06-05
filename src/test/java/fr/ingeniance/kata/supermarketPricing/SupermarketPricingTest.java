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
 * Classe pour tester le calcule des prix des marchandises dans les supermarchés
 * 
 * @author SAAIDI
 */
public class SupermarketPricingTest {

	/**
	 * Acheter 5 produits A sans réduction 
	 * 
	 * Prix unitaire = 1
	 */
	@Test
	public void productWithoutDiscount() throws IllegalUnitException {
		Product product = new Product("A", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.price.totalPrice(product);
		Assert.assertEquals(new BigDecimal("5.000"), totalPrice);
	}

	/**
	 * Acheter 5 produits B avec la remise (2 achetés = le troisième gratuit) 
	 * 
	 * Prix unitaire = 1
	 */
	@Test
	public void productWithBuy2AndGet1Discount() throws IllegalUnitException {
		Product product = new Product("B", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.price.totalPrice(product);
		Assert.assertEquals(new BigDecimal("4.000"), totalPrice);
	}

	/**
	 * Acheter 5 produits B avec la remise (3 achetés = 2 gratuit) 
	 * 
	 * Prix unitaire = 1
	 */
	@Test
	public void productWithBuy3AndGet2Discount() throws IllegalUnitException {
		Product product = new Product("BB", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.price.totalPrice(product);
		Assert.assertEquals(new BigDecimal("3.000"), totalPrice);
	}

	/**
	 * Acheter 5 produits C avec la remise (acheter 3 pour 1 dollar) 
	 * 
	 * Prix unitaire = 1
	 */
	@Test
	public void productWithGet3For1DollarDiscount() throws IllegalUnitException {
		Product product = new Product("C", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.price.totalPrice(product);
		Assert.assertEquals(new BigDecimal("3.000"), totalPrice);
	}

	/**
	 * Acheter 5 produits CC avec la remise (acheter 5 pour 3,99 dollars) 
	 * 
	 * Prix unitaire = 1
	 */
	@Test
	public void productWithGet5For399DollarDiscount() throws IllegalUnitException {
		Product product = new Product("CC", new BigDecimal("5.0"), UnitEnum.UNIT);
		BigDecimal totalPrice = SupermarketPricing.price.totalPrice(product);
		Assert.assertEquals(new BigDecimal("3.990"), totalPrice);
	}

	/**
	 * Produit D : 1.99/pound 
	 * 
	 * Acheter 4 ounces pour 0.498 dollars
	 */
	@Test
	public void productWithChangePoundToOunce() throws IllegalUnitException {
		Product product = new Product("D", new BigDecimal("4.0"), UnitEnum.OUNCE);
		BigDecimal totalPrice = SupermarketPricing.price.totalPrice(product);
		Assert.assertEquals(new BigDecimal("0.498"), totalPrice);
	}

	/**
	 * Produit DD : 0.25/ounce 
	 * 
	 * Acheter 1 pound pour 4 dollars
	 */
	@Test
	public void productWithChangeOunceToPound() throws IllegalUnitException {
		Product product = new Product("DD", new BigDecimal("1.0"), UnitEnum.POUND);
		BigDecimal totalPrice = SupermarketPricing.price.totalPrice(product);
		Assert.assertEquals(new BigDecimal("4.000"), totalPrice);
	}

	/**
	 * Essayez d'acheter 5 unités de produit D calculées en pound ou en ounce
	 */
	@Test
	public void productWithUnitException() {
		Product productA = new Product("D", new BigDecimal("5.0"), UnitEnum.UNIT);
		try {
			SupermarketPricing.price.totalPrice(productA);
			Assert.assertTrue(false);
		} catch (IllegalUnitException e) {
			Assert.assertTrue(true);
		}
	}

}
