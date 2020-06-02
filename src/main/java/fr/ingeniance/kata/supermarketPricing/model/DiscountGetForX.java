/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.model;

import java.math.BigDecimal;

/**
 * Classe remise de type Achetez X pour le prix de Y
 * 
 * @author SAAIDI
 *
 */
public class DiscountGetForX extends Discount {

	private BigDecimal price;

	/**
	 * @param quantity
	 * @param price
	 */
	public DiscountGetForX(BigDecimal quantity, BigDecimal price) {
		super(quantity);
		this.price = price;
	}

	/**
	 * Retourne le prix après remise
	 * 
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Met à jour le prix après remise
	 * 
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
