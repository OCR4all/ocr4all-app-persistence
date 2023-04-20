/**
 * File:     View.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     18.04.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Item;

/**
 * Defines views.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class View extends Item {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The model.
	 */
	private String model = null;

	/**
	 * Default constructor for a view.
	 * 
	 * @since 1.8
	 */
	protected View() {
		super();
	}

	/**
	 * Creates a workflow.
	 * 
	 * @param model The model.
	 * @since 1.8
	 */
	public View(String model) {
		super();

		this.model = model;
	}

	/**
	 * Returns the model.
	 *
	 * @return The model.
	 * @since 1.8
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Set the model.
	 *
	 * @param model The model to set.
	 * @since 1.8
	 */
	public void setModel(String model) {
		this.model = model;
	}

}
