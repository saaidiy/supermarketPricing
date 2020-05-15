/**
 * 
 */
package fr.ingeniance.kata.supermarketPricing.model;

import java.math.BigDecimal;

import fr.ingeniance.kata.supermarketPricing.utils.UnitEnum;

/**
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the unit
	 */
	public UnitEnum getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

}
