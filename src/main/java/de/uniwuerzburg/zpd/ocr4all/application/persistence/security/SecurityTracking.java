/**
 * File:     SecurityTracking.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.repository
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     23.11.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.security;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Tracking;

/**
 * Defines securities with tracking.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class SecurityTracking extends Tracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The security.
	 */
	private SecurityOwner security = null;

	/**
	 * Default constructor for a security with tracking.
	 * 
	 * @since 1.8
	 */
	public SecurityTracking() {
		super();
	}

	/**
	 * Creates a security with current created and updated time.
	 * 
	 * @param user The user.
	 * @since 1.8
	 */
	public SecurityTracking(String user) {
		super(new Date(), user);

		updated = getDate();
	}

	/**
	 * Creates a repository.
	 * 
	 * @param created The created time.
	 * @param updated The updated time. If null, uses the created time.
	 * @param user    The user.
	 * @since 1.8
	 */
	public SecurityTracking(Date created, Date updated, String user) {
		super(created, user);

		this.updated = updated;
	}

	/**
	 * Returns the updated time.
	 *
	 * @return The updated time.
	 * @since 1.8
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * Set the updated time.
	 *
	 * @param updated The updated time to set.
	 * @since 1.8
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * Returns the security.
	 *
	 * @return The security.
	 * @since 1.8
	 */
	public SecurityOwner getSecurity() {
		return security;
	}

	/**
	 * Set the security.
	 *
	 * @param security The security to set.
	 * @since 1.8
	 */
	public void setSecurity(SecurityOwner security) {
		this.security = security;
	}

}
