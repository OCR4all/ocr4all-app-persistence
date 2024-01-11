/**
 * File:     History.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence
 *
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     26.03.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence;

/**
 * Defines histories.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class History extends Tracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Defines history levels.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum Level {
		/**
		 * Trace level
		 */
		trace,
		/**
		 * Debug level
		 */
		debug,
		/**
		 * Info level
		 */
		info,
		/**
		 * Warn level
		 */
		warn,
		/**
		 * Error level
		 */
		error
	}

	/**
	 * The level. The default level is info.
	 */
	private Level level = Level.info;

	/**
	 * Default constructor for a history with level info.
	 *
	 * @since 1.8
	 */
	protected History() {
		super();
	}

	/**
	 * Creates a history.
	 *
	 * @param level The level to set. If it is null, then info is used.
	 * @since 1.8
	 */
	protected History(Level level) {
		super();

		setLevel(level);
	}

	/**
	 * Returns the level.
	 *
	 * @return The level.
	 * @since 1.8
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Set the level.
	 *
	 * @param level The level to set if it is non null.
	 * @since 1.8
	 */
	public void setLevel(Level level) {
		if (level != null)
			this.level = level;
	}

}
