/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.model;

import java.math.BigDecimal;

/**
 * Classe mère des remises
 * 
 * @author SAAIDI
 *
 */
public abstract class Discount {

	public BigDecimal quantity;

	/**
	 * @param quantity
	 */
	public Discount(BigDecimal quantity) {
		super();
		this.quantity = quantity;
	}

	/**
	 * Retourne la quantité pour avoir la remise.
	 * 
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Met à jour la quantité pour avoir la remise.
	 * 
	 * @param quantity la nouvelle quantité pour avoir la remise.
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
