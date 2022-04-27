/**
 * File:     Instance.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.util
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     11.03.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence;

import java.io.Serializable;

/**
 * Defines instances.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Instance implements Serializable {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	private long id = 0;

	/**
	 * The name.
	 */
	private String name = null;

	/**
	 * Default constructor for an instance.
	 * 
	 * @since 1.8
	 */
	public Instance() {
		super();
	}

	/**
	 * Creates an instance.
	 * 
	 * @param id   The id.
	 * @param name The name.
	 * @since 1.8
	 */
	public Instance(long id, String name) {
		super();

		this.id = id;
		this.name = name;
	}

	/**
	 * Returns the id.
	 *
	 * @return The id.
	 * @since 1.8
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set the id.
	 *
	 * @param id The id to set.
	 * @since 1.8
	 */
	public void setId(long id) {
		if (id <= 0)
			this.id = 0;
		else
			this.id = id;
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

}
