/**
 * File:     Workflow.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.job
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     17.04.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.job;

import java.util.List;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Item;

/**
 * Defines workflow.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Workflow extends Item {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The identifier.
	 */
	private String id = null;

	/**
	 * The paths.
	 */
	private List<Path> paths;

	/**
	 * The processors.
	 */
	private List<Processor> processors;

	/**
	 * Default constructor for a workflow.
	 * 
	 * @since 1.8
	 */
	protected Workflow() {
		super();
	}

	/**
	 * Creates a workflow.
	 * 
	 * @param id         The identifier.
	 * @param paths      The paths.
	 * @param processors The processors.
	 * @since 1.8
	 */
	public Workflow(String id, List<Path> paths, List<Processor> processors) {
		super();
		
		this.id = id;
		this.paths = paths;
		this.processors = processors;
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
	 * Returns the paths.
	 *
	 * @return The paths.
	 * @since 1.8
	 */
	public List<Path> getPaths() {
		return paths;
	}

	/**
	 * Set the paths.
	 *
	 * @param paths The paths to set.
	 * @since 1.8
	 */
	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}

	/**
	 * Returns the processors.
	 *
	 * @return The processors.
	 * @since 1.8
	 */
	public List<Processor> getProcessors() {
		return processors;
	}

	/**
	 * Set the processors.
	 *
	 * @param processors The processors to set.
	 * @since 1.8
	 */
	public void setProcessors(List<Processor> processors) {
		this.processors = processors;
	}

}
