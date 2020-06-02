package fr.ingeniance.kata.supermarketPricing.utils;

import java.math.BigDecimal;

import fr.ingeniance.kata.supermarketPricing.model.Product;

/**
 * Une interface pour calculer le prix
 * 
 * @author SAAIDI
 *
 */
@FunctionalInterface
public interface IPrice {

	/**
	 * Cette methode permet de calculer le prix d'un produit
	 * 
	 * @param product le produit
	 * @return Le prix du produit
	 * @throws IllegalUnitException Si jamais l'unité est mal choisie.
	 */
	BigDecimal totalPrice(Product product) throws IllegalUnitException;

}
