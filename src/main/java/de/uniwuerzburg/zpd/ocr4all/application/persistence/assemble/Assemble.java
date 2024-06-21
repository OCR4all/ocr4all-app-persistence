/**
 * File:     Assemble.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.assemble
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     12.06.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.assemble;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityTracking;

/**
 * Defines assembles.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class Assemble extends SecurityTracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for an assemble.
	 * 
	 * @since 1.8
	 */
	public Assemble() {
		super();
	}

	/**
	 * Creates an assemble with current created and updated time.
	 * 
	 * @param user The user.
	 * @since 1.8
	 */
	public Assemble(String user) {
		super(user);
	}

	/**
	 * Creates an assemble.
	 * 
	 * @param created The created time.
	 * @param updated The updated time. If null, uses the created time.
	 * @param user    The user.
	 * @since 1.8
	 */
	public Assemble(Date created, Date updated, String user) {
		super(created, updated, user);
	}

}
