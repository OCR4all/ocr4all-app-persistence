/**
 * File:     Partition.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.repository
 *
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     24.07.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.exchange;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityGrantRW;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityRWKeyword;

/**
 * Defines partitions.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class Partition extends SecurityRWKeyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for a partition.
	 *
	 * @since 17
	 */
	public Partition() {
		super();
	}

	/**
	 * Creates a partition with current created and updated time.
	 *
	 * @param user The user.
	 * @since 17
	 */
	public Partition(String user) {
		super(user);
	}

	/**
	 * Creates a partition.
	 *
	 * @param created     The created time.
	 * @param updated     The updated time. If null, uses the created time.
	 * @param user        The user.
	 * @param name        The name.
	 * @param description The description.
	 * @param security    The security.
	 * @since 17
	 */
	public Partition(Date created, Date updated, String user, String name, String description,
			SecurityGrantRW security) {
		super(created, updated, user, name, description, security);
	}

}
