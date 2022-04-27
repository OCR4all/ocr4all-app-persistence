/**
 * File:     ServiceProvider.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.spi
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     09.03.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.spi;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines service providers.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class ServiceProvider implements Serializable {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	private String id;

	/**
	 * The boolean arguments.
	 */
	private List<BooleanArgument> booleans;

	/**
	 * The decimal arguments.
	 */
	private List<DecimalArgument> decimals;

	/**
	 * The integer arguments.
	 */
	private List<IntegerArgument> integers;

	/**
	 * The string arguments.
	 */
	private List<StringArgument> strings;

	/**
	 * The image arguments.
	 */
	private List<ImageArgument> images;

	/**
	 * The recognition model arguments.
	 */
	@JsonProperty("recognition-model")
	private List<RecognitionModelArgument> recognitionModels;

	/**
	 * The select arguments.
	 */
	private List<SelectArgument> selects;

	/**
	 * Default constructor for a service provider.
	 * 
	 * @since 1.8
	 */
	public ServiceProvider() {
		super();
	}

	/**
	 * Creates a service provider using the fields of given service provider.
	 * 
	 * @param serviceProvider The source service provider.
	 * @since 1.8
	 */
	public ServiceProvider(ServiceProvider serviceProvider) {
		super();

		if (serviceProvider != null) {
			id = serviceProvider.getId() == null || serviceProvider.getId().isBlank() ? null
					: serviceProvider.getId().trim();
			booleans = serviceProvider.getBooleans();
			decimals = serviceProvider.getDecimals();
			integers = serviceProvider.getIntegers();
			strings = serviceProvider.getStrings();
			images = serviceProvider.getImages();
			recognitionModels = serviceProvider.getRecognitionModels();
			selects = serviceProvider.getSelects();
		}
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
	 * Returns the booleans.
	 *
	 * @return The booleans.
	 * @since 1.8
	 */
	public List<BooleanArgument> getBooleans() {
		return booleans;
	}

	/**
	 * Set the booleans.
	 *
	 * @param booleans The booleans to set.
	 * @since 1.8
	 */
	public void setBooleans(List<BooleanArgument> booleans) {
		this.booleans = booleans;
	}

	/**
	 * Returns the decimals.
	 *
	 * @return The decimals.
	 * @since 1.8
	 */
	public List<DecimalArgument> getDecimals() {
		return decimals;
	}

	/**
	 * Set the decimals.
	 *
	 * @param decimals The decimals to set.
	 * @since 1.8
	 */
	public void setDecimals(List<DecimalArgument> decimals) {
		this.decimals = decimals;
	}

	/**
	 * Returns the integers.
	 *
	 * @return The integers.
	 * @since 1.8
	 */
	public List<IntegerArgument> getIntegers() {
		return integers;
	}

	/**
	 * Set the integers.
	 *
	 * @param integers The integers to set.
	 * @since 1.8
	 */
	public void setIntegers(List<IntegerArgument> integers) {
		this.integers = integers;
	}

	/**
	 * Returns the strings.
	 *
	 * @return The strings.
	 * @since 1.8
	 */
	public List<StringArgument> getStrings() {
		return strings;
	}

	/**
	 * Set the strings.
	 *
	 * @param strings The strings to set.
	 * @since 1.8
	 */
	public void setStrings(List<StringArgument> strings) {
		this.strings = strings;
	}

	/**
	 * Returns the images.
	 *
	 * @return The images.
	 * @since 1.8
	 */
	public List<ImageArgument> getImages() {
		return images;
	}

	/**
	 * Set the images.
	 *
	 * @param images The images to set.
	 * @since 1.8
	 */
	public void setImages(List<ImageArgument> images) {
		this.images = images;
	}

	/**
	 * Returns the recognitionModels.
	 *
	 * @return The recognitionModels.
	 * @since 1.8
	 */
	public List<RecognitionModelArgument> getRecognitionModels() {
		return recognitionModels;
	}

	/**
	 * Set the recognitionModels.
	 *
	 * @param recognitionModels The recognitionModels to set.
	 * @since 1.8
	 */
	public void setRecognitionModels(List<RecognitionModelArgument> recognitionModels) {
		this.recognitionModels = recognitionModels;
	}

	/**
	 * Returns the selects.
	 *
	 * @return The selects.
	 * @since 1.8
	 */
	public List<SelectArgument> getSelects() {
		return selects;
	}

	/**
	 * Set the selects.
	 *
	 * @param selects The selects to set.
	 * @since 1.8
	 */
	public void setSelects(List<SelectArgument> selects) {
		this.selects = selects;
	}

}
