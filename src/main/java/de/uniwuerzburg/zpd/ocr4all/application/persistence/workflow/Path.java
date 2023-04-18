/**
 * File:     Path.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     17.04.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow;

import java.io.Serializable;
import java.util.List;

/**
 * Defines paths.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Path implements Serializable {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	private String id = null;

	/**
	 * The children.
	 */
	private List<Path> children;

	/**
	 * Default constructor for a path.
	 * 
	 * @since 1.8
	 */
	public Path() {
		super();
	}

	/**
	 * Returns the id.
	 *
	 * @return The id.
	 * @since 1.8
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the id.
	 *
	 * @param id The id to set.
	 * @since 1.8
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the children.
	 *
	 * @return The children.
	 * @since 1.8
	 */
	public List<Path> getChildren() {
		return children;
	}

	/**
	 * Set the children.
	 *
	 * @param children The children to set.
	 * @since 1.8
	 */
	public void setChildren(List<Path> children) {
		this.children = children;
	}

}
