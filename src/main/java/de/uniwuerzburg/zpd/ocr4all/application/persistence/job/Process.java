/**
 * File:     Process.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.job
 *
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     10.03.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.job;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Tracking;

/**
 * Defines processes.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Process extends Tracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Defines states.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum State {
		/**
		 * Initialized state
		 */
		initialized,
		/**
		 * Scheduled state
		 */
		scheduled,
		/**
		 * Running state
		 */
		running,
		/**
		 * Completed state
		 */
		completed,
		/**
		 * Cancelled state
		 */
		canceled,
		/**
		 * Interrupted state
		 */
		interrupted
	}

	/**
	 * The state.
	 */
	private State state = null;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The progress. This is a value between 0 and 1 inclusive. The initial value is
	 * 0.
	 */
	private float progress = 0;

	/**
	 * The standard output message.
	 */
	@JsonProperty("standard-output")
	private String standardOutput = null;

	/**
	 * The standard error message.
	 */
	@JsonProperty("standard-error")
	private String standardError = null;

	/**
	 * The note.
	 */
	private String note = null;

	/**
	 * Default constructor for a process.
	 *
	 * @since 1.8
	 */
	public Process() {
		super();
	}

	/**
	 * Creates a process with current created and updated time.
	 *
	 * @param user The user.
	 * @since 1.8
	 */
	public Process(String user) {
		super(new Date(), user);

		updated = getDate();
	}

	/**
	 * Creates a process.
	 *
	 * @param state          The state.
	 * @param progress       The progress. This is a value between 0 and 1
	 *                       inclusive. The initial value is 0.
	 * @param standardOutput The standard output message.
	 * @param standardError  The standard error message.
	 * @param note           The note.
	 * @param created        The created time.
	 * @param updated        The updated time. If null, uses the created time.
	 * @param user           The user.
	 * @since 1.8
	 */
	public Process(State state, float progress, String standardOutput, String standardError, String note, Date created,
			Date updated, String user) {
		super(created, user);

		this.state = state;

		this.progress = progress;

		this.standardOutput = standardOutput;
		this.standardError = standardError;
		this.note = note;

		this.updated = updated;
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
	 * Returns the progress. This is a value between 0 and 1 inclusive. The initial
	 * value is 0.
	 *
	 * @return The progress.
	 * @since 1.8
	 */
	public float getProgress() {
		return progress;
	}

	/**
	 * Set the progress. This is a value between 0 and 1 inclusive. The initial
	 * value is 0.
	 *
	 * @param progress The progress to set.
	 * @since 1.8
	 */
	public void setProgress(float progress) {
		this.progress = progress;
	}

	/**
	 * Returns the standard output message.
	 *
	 * @return The standard output message.
	 * @since 1.8
	 */
	public String getStandardOutput() {
		return standardOutput;
	}

	/**
	 * Set the standard output message.
	 *
	 * @param message The message to set.
	 * @since 1.8
	 */
	public void setStandardOutput(String message) {
		standardOutput = message;
	}

	/**
	 * Returns the standard error message.
	 *
	 * @return The standard error message.
	 * @since 1.8
	 */
	public String getStandardError() {
		return standardError;
	}

	/**
	 * Set the standard error message.
	 *
	 * @param message The message to set.
	 * @since 1.8
	 */
	public void setStandardError(String message) {
		this.standardError = message;
	}

	/**
	 * Returns the note.
	 *
	 * @return The note.
	 * @since 1.8
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Set the note.
	 *
	 * @param note The note to set.
	 * @since 1.8
	 */
	public void setNote(String note) {
		this.note = note;
	}
}
