/**
 * File:     Engine.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.assemble
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     12.06.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.assemble;

import java.util.Date;
import java.util.List;

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
	 * Defines states.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum State {
		/**
		 * The running state.
		 */
		running,
		/**
		 * The completed state.
		 */
		completed,
		/**
		 * The canceled state.
		 */
		canceled,
		/**
		 * The interrupted state.
		 */
		interrupted;

		/**
		 * Returns true if the job is done.
		 * 
		 * @return True if the job is done.
		 * @since 17
		 */
		public boolean isDone() {
			switch (this) {
			case canceled:
			case completed:
			case interrupted:
				return true;
			default:
				return false;
			}
		}
	}

	/**
	 * The type.
	 */
	private Type type;

	/**
	 * The state.
	 */
	private State state;

	/**
	 * The version.
	 */
	private String version;

	/**
	 * The arguments.
	 */
	private List<String> arguments;

	/**
	 * Default constructor for an engine.
	 * 
	 * @since 17
	 */
	public Engine() {
		super();
	}

	/**
	 * Creates an engine with current created and updated time and running state.
	 * 
	 * @param user    The user.
	 * @param type    The type.
	 * @param version The version.
	 * @param type    The type.
	 * @since 1.8
	 */
	public Engine(String user, Type type, String version, List<String> arguments) {
		super(new Date(), user);

		state = State.running;
		
		this.version = version;
		this.arguments = arguments;
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
	 * Returns the state.
	 *
	 * @return The state.
	 * @since 17
	 */
	public State getState() {
		return state;
	}

	/**
	 * Set the state.
	 *
	 * @param state The state to set.
	 * @since 17
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Returns the version.
	 *
	 * @return The version.
	 * @since 17
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Set the version.
	 *
	 * @param version The version to set.
	 * @since 17
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Returns the arguments.
	 *
	 * @return The arguments.
	 * @since 17
	 */
	public List<String> getArguments() {
		return arguments;
	}

	/**
	 * Set the arguments.
	 *
	 * @param arguments The arguments to set.
	 * @since 17
	 */
	public void setArguments(List<String> arguments) {
		this.arguments = arguments;
	}

}
