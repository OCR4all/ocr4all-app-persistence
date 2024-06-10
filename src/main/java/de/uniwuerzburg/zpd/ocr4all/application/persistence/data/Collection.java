/**
 * File:     Collection.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.data
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     22.05.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.data;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Keyword;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.security.SecurityGrant;

/**
 * Defines collections.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class Collection extends Keyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The name.
	 */
	private String name = null;

	/**
	 * The description.
	 */
	private String description = null;

	/**
	 * The security.
	 */
	private SecurityGrant security = null;

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
		super(new Date(), user);

		updated = getDate();
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
		super(created, user);

		this.updated = updated;
		this.name = name;
		this.description = description;
		this.security = security;
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
	 * Returns the name.
	 *
	 * @return The name.
	 * @since 1.8
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name.
	 *
	 * @param name The name to set.
	 * @since 1.8
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the description.
	 *
	 * @return The description.
	 * @since 1.8
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description.
	 *
	 * @param description The description to set.
	 * @since 1.8
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the security.
	 *
	 * @return The security.
	 * @since 1.8
	 */
	public SecurityGrant getSecurity() {
		return security;
	}

	/**
	 * Set the security.
	 *
	 * @param security The security to set.
	 * @since 1.8
	 */
	public void setSecurity(SecurityGrant security) {
		this.security = security;
	}

}
