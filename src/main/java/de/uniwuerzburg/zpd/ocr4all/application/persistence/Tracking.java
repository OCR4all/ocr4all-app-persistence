/**
 * File:     Tracking.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     26.03.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence;

import java.util.Date;

/**
 * Defines tracking for entities.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Tracking extends Entity {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The date.
	 */
	private Date date = null;

	/**
	 * The user.
	 */
	private String user = null;

	/**
	 * Default constructor for a tracking of an entity.
	 * 
	 * @since 1.8
	 */
	protected Tracking() {
		super();
	}

	/**
	 * Creates a tracking of an entity.
	 * 
	 * @param date The date.
	 * @param user The user.
	 * @since 1.8
	 */
	protected Tracking(Date date, String user) {
		super();

		this.date = date;
		this.user = user;
	}

	/**
	 * Returns the date.
	 *
	 * @return The date.
	 * @since 1.8
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set the date.
	 *
	 * @param date The date to set.
	 * @since 1.8
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns the user.
	 *
	 * @return The user.
	 * @since 1.8
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Set the user.
	 *
	 * @param user The user to set.
	 * @since 1.8
	 */
	public void setUser(String user) {
		this.user = user == null || user.isBlank() ? null : user.trim();
	}
}
