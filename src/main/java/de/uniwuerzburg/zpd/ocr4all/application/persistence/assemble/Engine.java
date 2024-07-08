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
		 * Returns true if the engine is done.
		 * 
		 * @return True if the engine is done.
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
	private Type type = Type.Calamari;

	/**
	 * The state.
	 */
	private State state = State.initialized;

	/**
	 * The version.
	 */
	private String version;

	/**
	 * True if model was created using a processor.
	 */
	@JsonProperty("processor")
	private boolean isProcessor;

	/**
	 * The name.
	 */
	private String name;

	/**
	 * The arguments.
	 */
	private List<String> arguments;

	/**
	 * The done time. Null if running.
	 */
	private Date done = null;

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
	 * @param state       The initial state. If null, the state is set initialized.
	 * @param user        The user.
	 * @param type        The type.
	 * @param version     The version.
	 * @param isProcessor True if model was created using a processor.
	 * @param name        The name.
	 * @param arguments   The arguments.
	 * @throws IllegalArgumentException Throws if the type is null.
	 * @since 17
	 */
	public Engine(State state, String user, Type type, String version, boolean isProcessor, String name,
			List<String> arguments) throws IllegalArgumentException {
		super(new Date(), user);

		if (type == null)
			throw new IllegalArgumentException("the engine type can not be null");

		setState(state == null ? State.initialized : state);

		this.type = type;
		this.version = version;
		this.isProcessor = isProcessor;
		this.name = name;
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
		if (type != null)
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
	 * Set the state and update the done time if required.
	 *
	 * @param state The state to set.
	 * @since 17
	 */
	public void setState(State state) {
		if (this.state != null) {
			this.state = state;

			if (this.state.isDone())
				done = new Date();
		}
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
	 * Returns true if model was created using a processor
	 *
	 * @return True if model was created using a processor
	 * @since 17
	 */
	@JsonGetter("processor")
	public boolean isProcessor() {
		return isProcessor;
	}

	/**
	 * Set to true if model was created using a processor
	 *
	 * @param isProcessor The processor flag to set.
	 * @since 17
	 */
	public void setProcessor(boolean isProcessor) {
		this.isProcessor = isProcessor;
	}

	/**
	 * Returns the name.
	 *
	 * @return The name.
	 * @since 17
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name.
	 *
	 * @param name The name to set.
	 * @since 17
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * Returns the done time. Null if running.
	 *
	 * @return The done time. Null if running.
	 * @since 17
	 */
	public Date getDone() {
		return done;
	}

}
