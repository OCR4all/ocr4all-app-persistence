/**
 * File:     Identifier.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.spi
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     07.07.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence;

import java.util.Date;

/**
 * Defines identifiers with tracking support.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Identifier extends Tracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The identifier.
	 */
	private String id = null;

	/**
	 * Default constructor for an identifier with tracking support.
	 * 
	 * @since 1.8
	 */
	public Identifier() {
		super();
	}

	/**
	 * Creates an identifier with tracking support.
	 * 
	 * @param date The date.
	 * @param user The user.
	 * @since 1.8
	 */
	public Identifier(Date date, String user) {
		super(date, user);
	}

	/**
	 * Creates an identifier with current date and tracking support.
	 * 
	 * @param user The user.
	 * @param id   The service provider id.
	 * @since 1.8
	 */
	public Identifier(String user, String id) {
		this(new Date(), user, id);
	}

	/**
	 * Creates an identifier with tracking support.
	 * 
	 * @param date The date.
	 * @param user The user.
	 * @param id   The service provider id.
	 * @since 1.8
	 */
	public Identifier(Date date, String user, String id) {
		super(date, user);

		this.id = id;
	}

	/**
	 * Returns the identifier.
	 *
	 * @return The identifier.
	 * @since 1.8
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the identifier.
	 *
	 * @param id The identifier to set.
	 * @since 1.8
	 */
	public void setId(String id) {
		this.id = id;
	}

}
