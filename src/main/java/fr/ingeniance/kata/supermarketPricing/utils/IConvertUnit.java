package fr.ingeniance.kata.supermarketPricing.utils;

import java.math.BigDecimal;

import org.javatuples.Pair;

/**
 * Une interface pour convertir l'unité de mesure
 * 
 * @author SAAIDI
 *
 */
@FunctionalInterface
public interface IConvertUnit {

	/**
	 * Cette methode permet de calculer le prix par unité de mesure
	 * 
	 * @param price : prix et unité de mesure par défaut
	 * @param price : unité de mesure
	 * @return Le prix correspondant à l'unité choisie
	 * @throws IllegalUnitException Si jamais l'unité est mal choisie.
	 */
	BigDecimal convert(Pair<BigDecimal, UnitEnum> price, UnitEnum unit) throws IllegalUnitException;

}
