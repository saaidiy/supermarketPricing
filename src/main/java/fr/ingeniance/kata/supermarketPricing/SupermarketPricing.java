/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing;

import java.math.BigDecimal;

import fr.ingeniance.kata.supermarketPricing.model.Discount;
import fr.ingeniance.kata.supermarketPricing.model.DiscountBuyAndGet;
import fr.ingeniance.kata.supermarketPricing.model.DiscountGetForX;
import fr.ingeniance.kata.supermarketPricing.utils.DiscountDictionary;
import fr.ingeniance.kata.supermarketPricing.utils.IConvertUnit;
import fr.ingeniance.kata.supermarketPricing.utils.IPrice;
import fr.ingeniance.kata.supermarketPricing.utils.IllegalUnitException;
import fr.ingeniance.kata.supermarketPricing.utils.PriceDictionary;
import fr.ingeniance.kata.supermarketPricing.utils.UnitEnum;

/**
 * 
 * Calculer les prix des marchandises dans les supermarchés
 * 
 * @author SAAIDI
 *
 */
public class SupermarketPricing {

	/**
	 * Cette methode permet de calculer le prix par unité de mesure
	 * 
	 * @param price : prix et unité de mesure par défaut
	 * @param price : unité de mesure
	 * @return Le prix correspondant à l'unité choisie
	 * @throws IllegalUnitException Si jamais l'unité est mal choisie.
	 */
	static IConvertUnit converter = (price, unit) -> {
		if (price.getValue1().equals(unit)) {
			return price.getValue0();
		} else if (unit.equals(UnitEnum.OUNCE)) {
			return price.getValue0().divide(new BigDecimal("16.00"));
		} else if (unit.equals(UnitEnum.POUND)) {
			return price.getValue0().multiply(new BigDecimal("16.00"));
		} else {
			throw new IllegalUnitException();
		}
	};

	/**
	 * Cette methode permet de calculer le prix d'un produit
	 * 
	 * @param product le produit
	 * @return Le prix du produit
	 * @throws IllegalUnitException Si jamais l'unité est mal choisie.
	 */
	static IPrice price = product -> {
		BigDecimal result = new BigDecimal("0.0");
		Discount discount = DiscountDictionary.discountMap.get(product.getName());
		BigDecimal priceUnit = converter.convert(PriceDictionary.priceMap.get(product.getName()), product.getUnit());
		BigDecimal[] divideAndRemainder = {};
		if (discount == null) {
			result = priceUnit.multiply(product.getQuantity()).setScale(3, BigDecimal.ROUND_HALF_UP);
		} else if (discount instanceof DiscountBuyAndGet) {
			DiscountBuyAndGet buyAndGet = (DiscountBuyAndGet) discount;
			divideAndRemainder = product.getQuantity()
					.divideAndRemainder(buyAndGet.getQuantity().add(buyAndGet.getFree()));
			BigDecimal unitWithDiscount = divideAndRemainder[0].multiply(buyAndGet.getQuantity());
			BigDecimal unitWithoutDiscount = divideAndRemainder[1];
			BigDecimal totalUnitToBuy = unitWithDiscount.add(unitWithoutDiscount);
			result = totalUnitToBuy.multiply(priceUnit).setScale(3, BigDecimal.ROUND_HALF_UP);
		} else if (discount instanceof DiscountGetForX) {
			DiscountGetForX discountGetForX = (DiscountGetForX) discount;
			divideAndRemainder = product.getQuantity().divideAndRemainder(discountGetForX.getQuantity());
			BigDecimal priceWithDiscount = divideAndRemainder[0].multiply(discountGetForX.getPrice());
			BigDecimal priceWithoutDiscount = divideAndRemainder[1].multiply(priceUnit);
			result = priceWithDiscount.add(priceWithoutDiscount).setScale(3, BigDecimal.ROUND_HALF_UP);
		}
		return result;
	};

}
