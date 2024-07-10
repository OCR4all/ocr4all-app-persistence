/**
 * File:     WeightArgument.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.spi
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     08.03.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.spi;

import java.util.List;

/**
 * Defines weight arguments.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class WeightArgument extends Argument {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The assembles.
	 */
	private List<Assemble> assembles;

	/**
	 * Returns the assembles.
	 *
	 * @return The assembles.
	 * @since 17
	 */
	public List<Assemble> getAssembles() {
		return assembles;
	}

	/**
	 * Set the assembles.
	 *
	 * @param assembles The assembles to set.
	 * @since 17
	 */
	public void setAssembles(List<Assemble> assembles) {
		this.assembles = assembles;
	}

	/**
	 * Model is an immutable class that defines assembles.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 17
	 */
	public static class Assemble {
		/**
		 * The id.
		 */
		private String id;

		/**
		 * The models.
		 */
		private List<String> models;

		/**
		 * Creates an assemble.
		 * 
		 * @param id     The id.
		 * @param models The models.
		 * @since 17
		 */
		public Assemble(String id, List<String> models) throws IllegalArgumentException {
			super();

			if (id == null || id.isBlank())
				throw new IllegalArgumentException("the assemble argument id can not be empty.");
			this.id = id;

			this.models = models;
		}

		/**
		 * Returns the id.
		 *
		 * @return The id.
		 * @since 17
		 */
		public String getId() {
			return id;
		}

		/**
		 * Set the id.
		 *
		 * @param id The id to set.
		 * @since 17
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * Returns the models.
		 *
		 * @return The models.
		 * @since 17
		 */
		public List<String> getModels() {
			return models;
		}

		/**
		 * Set the models.
		 *
		 * @param models The models to set.
		 * @since 17
		 */
		public void setModels(List<String> models) {
			this.models = models;
		}

	}

}
