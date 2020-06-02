/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.model;

import java.math.BigDecimal;

/**
 * Classe remise de type Achetez X et obtenez Y
 * 
 * @author SAAIDI
 *
 */
public class DiscountBuyAndGet extends Discount {

	public BigDecimal free;

	/**
	 * @param quantity
	 * @param free
	 */
	public DiscountBuyAndGet(BigDecimal quantity, BigDecimal free) {
		super(quantity);
		this.free = free;
	}

	/**
	 * Retourne la quantité gratuite.
	 * 
	 * @return the free
	 */
	public BigDecimal getFree() {
		return free;
	}

	/**
	 * Met à jour la quantité gratuite.
	 * 
	 * @param free the free to set
	 */
	public void setFree(BigDecimal free) {
		this.free = free;
	}

}
