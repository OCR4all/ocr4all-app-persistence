/**
 * File:     Model.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.assemble
 *
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     12.06.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.assemble;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityGrant;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityKeyword;

/**
 * Defines models.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Model extends SecurityKeyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for a model.
	 *
	 * @since 1.8
	 */
	public Model() {
		super();
	}

	/**
	 * Creates a model with current created and updated time.
	 *
	 * @param user The user.
	 * @since 1.8
	 */
	public Model(String user) {
		super(user);
	}

	/**
	 * Creates a model.
	 *
	 * @param created     The created time.
	 * @param updated     The updated time. If null, uses the created time.
	 * @param user        The user.
	 * @param name        The name.
	 * @param description The description.
	 * @param security    The security.
	 * @since 1.8
	 */
	public Model(Date created, Date updated, String user, String name, String description, SecurityGrant security) {
		super(created, updated, user, name, description, security);
	}

}
