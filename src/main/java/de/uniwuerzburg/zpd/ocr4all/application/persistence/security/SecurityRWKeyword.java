/**
 * File:     SecurityKeyword.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.repository
 *
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     24.11.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.security;

import java.util.Date;

/**
 * Defines read/write securities with keyword support.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class SecurityRWKeyword extends SecurityCoreKeyword<SecurityGrantRW> {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for a read/write security with keyword support.
	 *
	 * @since 1.8
	 */
	public SecurityRWKeyword() {
		super();
	}

	/**
	 * Creates a read/write security with keyword support and current created and
	 * updated time.
	 *
	 * @param user The user.
	 * @since 1.8
	 */
	public SecurityRWKeyword(String user) {
		super(user);
	}

	/**
	 * Creates a read/write security with keyword support.
	 *
	 * @param created     The created time.
	 * @param updated     The updated time. If null, uses the created time.
	 * @param user        The user.
	 * @param name        The name.
	 * @param description The description.
	 * @param security    The security.
	 * @since 1.8
	 */
	public SecurityRWKeyword(Date created, Date updated, String user, String name, String description,
			SecurityGrantRW security) {
		super(created, updated, user, name, description, security);
	}

}
