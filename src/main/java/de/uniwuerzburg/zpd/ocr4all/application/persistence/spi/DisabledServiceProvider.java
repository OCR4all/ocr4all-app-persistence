/**
 * File:     DisabledServiceProvider.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.spi
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     04.07.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.spi;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Identifier;

/**
 * Defines disabled service providers.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class DisabledServiceProvider extends Identifier {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for a disabled service provider.
	 * 
	 * @since 1.8
	 */
	public DisabledServiceProvider() {
		super();
	}

	/**
	 * Creates a disabled service provider with current date.
	 * 
	 * @param user The user.
	 * @param id   The service provider id.
	 * @since 1.8
	 */
	public DisabledServiceProvider(String user, String id) {
		super(user, id);
	}

}
