/**
 * File:     Repository.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.repository
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     22.05.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.repository;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityTracking;

/**
 * Defines repositories.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Repository extends SecurityTracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for a repository.
	 * 
	 * @since 1.8
	 */
	public Repository() {
		super();
	}

	/**
	 * Creates a repository with current created and updated time.
	 * 
	 * @param user The user.
	 * @since 1.8
	 */
	public Repository(String user) {
		super(user);
	}

	/**
	 * Creates a repository.
	 * 
	 * @param created The created time.
	 * @param updated The updated time. If null, uses the created time.
	 * @param user    The user.
	 * @since 1.8
	 */
	public Repository(Date created, Date updated, String user) {
		super(created, updated, user);
	}

}
