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
	 * Defines methods.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 17
	 */
	public enum Method {
		/**
		 * The processor method.
		 */
		processor,
		/**
		 * The manual method.
		 */
		manual
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
		 * The uploading state
		 */
		uploading,
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
		interrupted,
		/**
		 * The undefined state.
		 */
		undefined;

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
		Tesseract,
		/**
		 * The undefined engine.
		 */
		undefined
	}

	/**
	 * The method. Default method is manual.
	 */
	private Method method = Method.manual;

	/**
	 * The state. Default state is undefined.
	 */
	private State state = State.undefined;

	/**
	 * The type. Default type is undefined.
	 */
	private Type type = Type.undefined;

	/**
	 * The version.
	 */
	private String version;

	/**
	 * The name.
	 */
	private String name;

	/**
	 * The arguments.
	 */
	private List<String> arguments;

	/**
	 * The done time. Null if not done.
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
	 * @param user      The user.
	 * @param method    The method. If null, the default method is used.
	 * @param state     The state. If null, the default state is used.
	 * @param type      The type. If null, the default type is used.
	 * @param version   The version.
	 * @param name      The name.
	 * @param arguments The arguments.
	 * @since 17
	 */
	public Engine(String user, Method method, State state, Type type, String version, String name,
			List<String> arguments) {
		super(new Date(), user);

		setMethod(method);
		setState(state);
		setType(type);

		this.version = version;
		this.name = name;
		this.arguments = arguments;
	}

	/**
	 * Returns the method.
	 *
	 * @return The method.
	 * @since 17
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * Set the method.
	 *
	 * @param method The method to set.
	 * @since 17
	 */
	public void setMethod(Method method) {
		if (method != null)
			this.method = method;
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
			else
				done = null;
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
