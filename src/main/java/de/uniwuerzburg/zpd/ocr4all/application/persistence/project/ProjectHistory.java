/**
 * File:     ProjectHistory.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.project
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     22.07.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.project;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.History;

/**
 * Defines project histories.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public abstract class ProjectHistory extends History {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for a project history with level info.
	 * 
	 * @since 1.8
	 */
	public ProjectHistory() {
		super();
	}

	/**
	 * Creates a project history.
	 * 
	 * @param level The level. If it is null, then info is used.
	 * @since 1.8
	 */
	public ProjectHistory(Level level) {
		super(level);
	}

}
