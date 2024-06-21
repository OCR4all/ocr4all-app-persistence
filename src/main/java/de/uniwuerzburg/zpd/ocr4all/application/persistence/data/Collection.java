/**
 * File:     Collection.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.data
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     22.05.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.data;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityGrant;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityKeyword;

/**
 * Defines collections.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class Collection extends SecurityKeyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for a collection.
	 *
	 * @since 1.8
	 */
	public Collection() {
		super();
	}

	/**
	 * Creates a collection with current created and updated time.
	 *
	 * @param user The user.
	 * @since 1.8
	 */
	public Collection(String user) {
		super(user);
	}

	/**
	 * Creates a collection.
	 *
	 * @param created     The created time.
	 * @param updated     The updated time. If null, uses the created time.
	 * @param user        The user.
	 * @param name        The name.
	 * @param description The description.
	 * @param security    The security.
	 * @since 1.8
	 */
	public Collection(Date created, Date updated, String user, String name, String description,
			SecurityGrant security) {
		super(created, updated, user, name, description, security);
	}

}
