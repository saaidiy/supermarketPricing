/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.model;

import java.math.BigDecimal;

/**
 * @author SAAIDI
 *
 */
public class DiscountBuyAndGet extends Discount {
	
	public BigDecimal free;

	/**
	 * @param type
	 * @param quantity
	 * @param free
	 */
	public DiscountBuyAndGet(BigDecimal quantity, BigDecimal free) {
		super(quantity);
		this.free = free;
	}

	/**
	 * @return the free
	 */
	public BigDecimal getFree() {
		return free;
	}

	/**
	 * @param free the free to set
	 */
	public void setFree(BigDecimal free) {
		this.free = free;
	}

	

}
