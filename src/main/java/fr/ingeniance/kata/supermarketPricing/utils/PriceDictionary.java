/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.utils;

import java.math.BigDecimal;
import java.util.TreeMap;

import org.javatuples.Pair;

/**
 * @author SAAIDI
 *
 */
public class PriceDictionary {
		
	public static TreeMap<String, Pair<BigDecimal, UnitEnum>> priceMap = new TreeMap<String, Pair<BigDecimal, UnitEnum>>();
	
	static{
		priceMap.put("A", new Pair<BigDecimal, UnitEnum>(new BigDecimal("1.00"), UnitEnum.UNIT));
		priceMap.put("B", new Pair<BigDecimal, UnitEnum>(new BigDecimal("1.00"), UnitEnum.UNIT));
		priceMap.put("BB", new Pair<BigDecimal, UnitEnum>(new BigDecimal("1.00"), UnitEnum.UNIT));
		priceMap.put("C", new Pair<BigDecimal, UnitEnum>(new BigDecimal("1.00"), UnitEnum.UNIT));
		priceMap.put("CC", new Pair<BigDecimal, UnitEnum>(new BigDecimal("1.00"), UnitEnum.UNIT));
		priceMap.put("D", new Pair<BigDecimal, UnitEnum>(new BigDecimal("1.99"), UnitEnum.POUND));
		priceMap.put("DD", new Pair<BigDecimal, UnitEnum>(new BigDecimal("0.25"), UnitEnum.OUNCE));
	}

}
