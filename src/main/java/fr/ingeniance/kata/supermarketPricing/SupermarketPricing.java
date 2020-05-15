/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing;

import java.math.BigDecimal;

import org.javatuples.Pair;

import fr.ingeniance.kata.supermarketPricing.model.Discount;
import fr.ingeniance.kata.supermarketPricing.model.DiscountBuyAndGet;
import fr.ingeniance.kata.supermarketPricing.model.DiscountGetForX;
import fr.ingeniance.kata.supermarketPricing.model.Product;
import fr.ingeniance.kata.supermarketPricing.utils.DiscountDictionary;
import fr.ingeniance.kata.supermarketPricing.utils.IllegalUnitException;
import fr.ingeniance.kata.supermarketPricing.utils.PriceDictionary;
import fr.ingeniance.kata.supermarketPricing.utils.UnitEnum;

/**
 * @author SAAIDI
 *
 */
public class SupermarketPricing {



	public static BigDecimal totalPrice(Product product) throws IllegalUnitException {
		BigDecimal result = new BigDecimal("0.0");
		Discount discount = DiscountDictionary.discountMap.get(product.getName());
		BigDecimal priceUnit = convertUnit(PriceDictionary.priceMap.get(product.getName()), product.getUnit());
		
		BigDecimal[] divideAndRemainder = {};
		if (discount == null) {
			result = priceUnit.multiply(product.getQuantity()).setScale(3, BigDecimal.ROUND_HALF_UP);
		} else if(discount instanceof DiscountBuyAndGet) {
			DiscountBuyAndGet buyAndGet = (DiscountBuyAndGet) discount;
			divideAndRemainder = product.getQuantity().divideAndRemainder(buyAndGet.getQuantity().add(buyAndGet.getFree()));
			BigDecimal unitWithDiscount = divideAndRemainder[0].multiply(buyAndGet.getQuantity());
			BigDecimal unitWithoutDiscount = divideAndRemainder[1];
			BigDecimal totalUnitToBuy = unitWithDiscount.add(unitWithoutDiscount);
			result = totalUnitToBuy.multiply(priceUnit).setScale(3, BigDecimal.ROUND_HALF_UP);
		} else if(discount instanceof DiscountGetForX) {
			DiscountGetForX discountGetForX = (DiscountGetForX) discount;
			divideAndRemainder = product.getQuantity().divideAndRemainder(discountGetForX.getQuantity());
			BigDecimal priceWithDiscount = divideAndRemainder[0].multiply(discountGetForX.getPrice());
			BigDecimal priceWithoutDiscount = divideAndRemainder[1].multiply(priceUnit);
			result = priceWithDiscount.add(priceWithoutDiscount).setScale(3, BigDecimal.ROUND_HALF_UP);
		}
		return result;
	}

	/**
	 * @param price
	 * @param unit
	 * @return
	 * @throws IllegalUnitException 
	 */
	private static BigDecimal convertUnit(Pair<BigDecimal, UnitEnum> price, UnitEnum unit) throws IllegalUnitException {
		if(price.getValue1().equals(unit)){
			return price.getValue0();
		}else if (unit.equals(UnitEnum.OUNCE)) {
			return price.getValue0().divide(new BigDecimal("16.00"));
		}else if (unit.equals(UnitEnum.POUND)) {
			return price.getValue0().multiply(new BigDecimal("16.00"));
		}else{
			throw new IllegalUnitException();
		}
	}

}
