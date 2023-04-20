/**
 * File:     MultipleValueArgument.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.spi
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     08.03.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.spi;

import java.util.List;

/**
 * Defines multiple value arguments.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @param <V> The value type.
 * @since 1.8
 */
public class MultipleValueArgument<V> extends Argument {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The values.
	 */
	private List<V> values;

	/**
	 * Returns the values.
	 *
	 * @return The values.
	 * @since 1.8
	 */
	public List<V> getValues() {
		return values;
	}

	/**
	 * Set the values.
	 *
	 * @param values The values to set.
	 * @since 1.8
	 */
	public void setValues(List<V> values) {
		this.values = values;
	}

}
