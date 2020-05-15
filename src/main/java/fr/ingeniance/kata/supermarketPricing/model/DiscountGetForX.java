/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.model;

import java.math.BigDecimal;

/**
 * @author SAAIDI
 *
 */
public class DiscountGetForX extends Discount {
	
	private BigDecimal price;
	
	/**
	 * @param type
	 * @param quantity
	 * @param price
	 */
	public DiscountGetForX(BigDecimal quantity, BigDecimal price) {
		super(quantity);
		this.price = price;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
