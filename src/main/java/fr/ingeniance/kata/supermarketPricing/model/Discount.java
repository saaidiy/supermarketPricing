/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.model;

import java.math.BigDecimal;

/**
 * @author SAAIDI
 *
 */
public abstract class Discount {
		
	public BigDecimal quantity;

	/**
	 * @param type
	 * @param quantity
	 */
	public Discount(BigDecimal quantity) {
		super();
		this.quantity = quantity;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
}
