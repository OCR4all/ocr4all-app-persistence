/**
 * File:     Sandbox.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.project.sandbox
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     07.04.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.project.sandbox;

import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Keyword;

/**
 * Defines sandboxes.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Sandbox extends Keyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Define states.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum State {
		active, secured, paused, closed, canceled
	}

	/**
	 * The name.
	 */
	private String name = null;

	/**
	 * The description.
	 */
	private String description = null;

	/**
	 * The state.
	 */
	private State state = null;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The done time.
	 */
	private Date done = null;

	/**
	 * Default constructor for a sandbox.
	 * 
	 * @since 1.8
	 */
	public Sandbox() {
		super();
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
	 * Returns the state.
	 *
	 * @return The state.
	 * @since 1.8
	 */
	public State getState() {
		return state;
	}

	/**
	 * Set the state.
	 *
	 * @param state The state to set.
	 * @since 1.8
	 */
	public void setState(State state) {
		this.state = state;
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
	 * Returns the done time.
	 *
	 * @return The done time.
	 * @since 1.8
	 */
	public Date getDone() {
		return done;
	}

	/**
	 * Set the done time.
	 *
	 * @param done The done time to set.
	 * @since 1.8
	 */
	public void setDone(Date done) {
		this.done = done;
	}

}
