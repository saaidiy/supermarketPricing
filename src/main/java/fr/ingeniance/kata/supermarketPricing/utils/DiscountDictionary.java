/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.utils;

import java.math.BigDecimal;
import java.util.TreeMap;

import fr.ingeniance.kata.supermarketPricing.model.Discount;
import fr.ingeniance.kata.supermarketPricing.model.DiscountBuyAndGet;
import fr.ingeniance.kata.supermarketPricing.model.DiscountGetForX;

/**
 * Base de données remises
 * 
 * @author SAAIDI
 */
public class DiscountDictionary {

	public static TreeMap<String, Discount> discountMap = new TreeMap<String, Discount>();

	static {
		// discountMap.put("A", new Discount(DiscountEnum.NORMAL, new BigDecimal("1.0"),
		// new BigDecimal("1.0")));
		discountMap.put("B", new DiscountBuyAndGet(new BigDecimal("2.0"), new BigDecimal("1.0")));
		discountMap.put("BB", new DiscountBuyAndGet(new BigDecimal("3.0"), new BigDecimal("2.0")));
		discountMap.put("C", new DiscountGetForX(new BigDecimal("3.0"), new BigDecimal("1.0")));
		discountMap.put("CC", new DiscountGetForX(new BigDecimal("5.0"), new BigDecimal("3.99")));

	}

}
