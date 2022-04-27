/**
 * File:     ActionHistory.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.project
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     22.07.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.project;

/**
 * Defines action histories.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class ActionHistory extends ProjectHistory {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The label.
	 */
	private String label = null;

	/**
	 * The description.
	 */
	private String description = null;

	/**
	 * The note.
	 */
	private String note = null;

	/**
	 * Default constructor for an action history with level info.
	 * 
	 * @since 1.8
	 */
	public ActionHistory() {
		super();
	}

	/**
	 * Creates an action history with info level.
	 * 
	 * @param label       The label.
	 * @param description The description.
	 * @param note        The note.
	 * @since 1.8
	 */
	public ActionHistory(String label, String description, String note) {
		this(null, label, description, note);
	}

	/**
	 * Creates an action history.
	 * 
	 * @param level       The level. If it is null, then info is used.
	 * @param label       The label.
	 * @param description The description.
	 * @param note        The note.
	 * @since 1.8
	 */
	public ActionHistory(Level level, String label, String description, String note) {
		super(level);

		setLabel(label);
		setDescription(description);
		setNote(note);
	}

	/**
	 * Returns the label.
	 *
	 * @return The label.
	 * @since 1.8
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Set the label.
	 *
	 * @param label The label to set.
	 * @since 1.8
	 */
	public void setLabel(String label) {
		this.label = label;
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
