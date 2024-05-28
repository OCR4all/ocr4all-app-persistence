/**
 * File:     Set.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.data
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     27.05.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.data;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Keyword;

/**
 * Defines sets for data collections.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class Set extends Keyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The identifier.
	 */
	private String id = null;

	/**
	 * The name without extension, i.e. the name up to the first dot, if available.
	 */
	private String name = null;

	/**
	 * Default constructor for a set.
	 * 
	 * @since 17
	 */
	public Set() {
		super();
	}

	/**
	 * Creates a set.
	 * 
	 * @param date The date.
	 * @param user The user.
	 * @param id   The id.
	 * @param name The name without extension, i.e. the name up to the first dot, if
	 *             available.
	 * @since 17
	 */
	public Set(Date date, String user, String id, String name) {
		this(date, user, null, id, name);
	}

	/**
	 * Creates a set.
	 * 
	 * @param date     The date.
	 * @param user     The user.
	 * @param keywords The keywords.
	 * @param id       The id.
	 * @param name     The name without extension, i.e. the name up to the first
	 *                 dot, if available.
	 * @since 17
	 */
	public Set(Date date, String user, java.util.Set<String> keywords, String id, String name) {
		super(date, user, keywords);

		this.id = id;
		this.name = name;
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

	/**
	 * Returns the name without extension, i.e. the name up to the first dot, if
	 * available.
	 *
	 * @return The name without extension.
	 * @since 1.8
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name without extension, i.e. the name up to the first dot.
	 *
	 * @param name The name without extension to set.
	 * @since 1.8
	 */
	public void setName(String name) {
		this.name = name;
	}

}
