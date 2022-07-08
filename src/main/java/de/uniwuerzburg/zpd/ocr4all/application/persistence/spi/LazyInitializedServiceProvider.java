/**
 * File:     LazyInitializedServiceProvider.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.spi
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     07.07.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.spi;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Identifier;

/**
 * Defines lazy initialized service providers.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class LazyInitializedServiceProvider extends Identifier {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for a lazy initialized service provider.
	 * 
	 * @since 1.8
	 */
	public LazyInitializedServiceProvider() {
		super();
	}

	/**
	 * Creates a lazy initialized service provider with current date.
	 * 
	 * @param user The user.
	 * @param id   The service provider id.
	 * @since 1.8
	 */
	public LazyInitializedServiceProvider(String user, String id) {
		super(user, id);
	}

}
