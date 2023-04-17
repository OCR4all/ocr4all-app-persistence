/**
 * File:     Metadata.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.job
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     17.04.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.job;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Identifier;

/**
 * Defines metadata for workflow.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Metadata extends Identifier {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The update user.
	 */
	@JsonProperty("update-user")
	private String updateUser = null;

	/**
	 * The label.
	 */
	private String label = null;

	/**
	 * The description.
	 */
	private String description = null;

	/**
	 * The view model.
	 */
	@JsonProperty("view-model")
	private String viewModel = null;

	/**
	 * Default constructor for a metadata for workflow.
	 * 
	 * @since 1.8
	 */
	public Metadata() {
		super();
	}

	/**
	 * Creates a metadata for workflow with current date.
	 * 
	 * @param user The user.
	 * @param id   The service provider id.
	 * @since 1.8
	 */
	public Metadata(String user, String id) {
		super(user, id);
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
	 * Returns the update user.
	 *
	 * @return The update user.
	 * @since 1.8
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * Set the update user.
	 *
	 * @param updateUser The update user to set.
	 * @since 1.8
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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
	 * Returns the view model.
	 *
	 * @return The view model.
	 * @since 1.8
	 */
	public String getViewModel() {
		return viewModel;
	}

	/**
	 * Set the view model.
	 *
	 * @param viewModel The view model to set.
	 * @since 1.8
	 */
	public void setViewModel(String viewModel) {
		this.viewModel = viewModel;
	}

}
