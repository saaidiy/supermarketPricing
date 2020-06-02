/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.model;

import java.math.BigDecimal;

import fr.ingeniance.kata.supermarketPricing.utils.UnitEnum;

/**
 * Classe Produit
 * 
 * @author SAAIDI
 *
 */
public class Product {

	public String name;

	public BigDecimal quantity;

	private UnitEnum unit;

	/**
	 * @param name
	 * @param quantity
	 * @param unit
	 */
	public Product(String name, BigDecimal quantity, UnitEnum unit) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}

	/**
	 * Retourne le nom du produit.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Met à jour le nom du produit.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne la quantité achetée
	 * 
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * met à jour la quantité achetée
	 * 
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * Retourne l'unité de mesure
	 * 
	 * @return the unit
	 */
	public UnitEnum getUnit() {
		return unit;
	}

	/**
	 * Met à jour l'unité de mesure
	 * 
	 * @param unit the unit to set
	 */
	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

}
