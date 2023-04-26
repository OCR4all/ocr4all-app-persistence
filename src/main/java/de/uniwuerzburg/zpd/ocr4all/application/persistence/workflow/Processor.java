/**
 * File:     Processor.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     17.04.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.spi.ServiceProvider;

/**
 * Defines processors.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Processor extends ServiceProvider {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The path id.
	 */
	@JsonProperty("path-id")
	private String idPath = null;

	/**
	 * Default constructor for a processor.
	 * 
	 * @since 1.8
	 */
	public Processor() {
		super();
	}

	/**
	 * Returns the path id.
	 *
	 * @return The idPath.
	 * @since 1.8
	 */
	public String getIdPath() {
		return idPath;
	}

	/**
	 * Set the path id.
	 *
	 * @param id The path id to set.
	 * @since 1.8
	 */
	public void setIdPath(String id) {
		idPath = id;
	}

}
