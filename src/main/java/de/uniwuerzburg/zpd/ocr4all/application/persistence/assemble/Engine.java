/**
 * File:     Engine.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.assemble
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     12.06.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.assemble;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Tracking;

/**
 * Defines engines.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class Engine extends Tracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Defines types.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 17
	 */
	public enum Type {
		/**
		 * The Calamari engine.
		 */
		Calamari,
		/**
		 * The Tesseract engine.
		 */
		Tesseract
	}

	/**
	 * The type.
	 */
	private Type type;

	/**
	 * The version.
	 */
	private float version;

	/**
	 * The arguments.
	 */
	private String arguments;

	/**
	 * True if the engine is ready.
	 */
	@JsonProperty("ready")
	private boolean isReady;

	/**
	 * Default constructor for an engine.
	 * 
	 * @since 17
	 */
	public Engine() {
		super();
	}

	/**
	 * Creates an engine with current created and updated time.
	 * 
	 * @param user The user.
	 * @since 1.8
	 */
	public Engine(String user) {
		super(new Date(), user);
	}

	/**
	 * Returns the type.
	 *
	 * @return The type.
	 * @since 17
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Set the type.
	 *
	 * @param type The type to set.
	 * @since 17
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Returns the version.
	 *
	 * @return The version.
	 * @since 17
	 */
	public float getVersion() {
		return version;
	}

	/**
	 * Set the version.
	 *
	 * @param version The version to set.
	 * @since 17
	 */
	public void setVersion(float version) {
		this.version = version;
	}

	/**
	 * Returns the arguments.
	 *
	 * @return The arguments.
	 * @since 17
	 */
	public String getArguments() {
		return arguments;
	}

	/**
	 * Set the arguments.
	 *
	 * @param arguments The arguments to set.
	 * @since 17
	 */
	public void setArguments(String arguments) {
		this.arguments = arguments;
	}

	/**
	 * Returns true if the engine is ready.
	 *
	 * @return True if the engine is ready.
	 * @since 17
	 */
	@JsonGetter("ready")
	public boolean isReady() {
		return isReady;
	}

	/**
	 * Set to true if the engine is ready.
	 *
	 * @param isReady The ready flag to set.
	 * @since 17
	 */
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

}
