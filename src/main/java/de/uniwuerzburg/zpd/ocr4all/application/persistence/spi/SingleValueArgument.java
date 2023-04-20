/**
 * File:     SingleValueArgument.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.spi
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     08.03.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.spi;

/**
 * Defines single value arguments.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @param <V> The value type.
 * @since 1.8
 */
public class SingleValueArgument<V> extends Argument {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The value.
	 */
	private V value;

	/**
	 * Returns the value.
	 *
	 * @return The value.
	 * @since 1.8
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Set the value.
	 *
	 * @param value The value to set.
	 * @since 1.8
	 */
	public void setValue(V value) {
		this.value = value;
	}

}
