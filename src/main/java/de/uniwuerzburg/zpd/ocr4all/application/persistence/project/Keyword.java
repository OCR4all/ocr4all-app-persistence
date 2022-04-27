/**
 * File:     Keyword.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.project
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     24.06.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.project;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Tracking;

/**
 * Defines keywords.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Keyword extends Tracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The keywords.
	 */
	private Set<String> keywords = null;

	/**
	 * Default constructor for a keyword.
	 * 
	 * @since 1.8
	 */
	protected Keyword() {
		super();
	}

	/**
	 * Creates a keyword.
	 * 
	 * @param date The date.
	 * @param user The user.
	 * @since 1.8
	 */
	protected Keyword(Date date, String user) {
		this(date, user, null);
	}

	/**
	 * Creates a keyword.
	 * 
	 * @param date     The date.
	 * @param user     The user.
	 * @param keywords The keywords.
	 * @since 1.8
	 */
	protected Keyword(Date date, String user, Set<String> keywords) {
		super(date, user);

		setKeywords(keywords);
	}

	/**
	 * Returns the keywords.
	 *
	 * @return The keywords.
	 * @since 1.8
	 */
	public Set<String> getKeywords() {
		return keywords;
	}

	/**
	 * Set the keywords. The keywords will be trimmed and converted to lower case.
	 *
	 * @param keywords The keywords to set.
	 * @since 1.8
	 */
	public void setKeywords(Set<String> keywords) {
		keywords = normalizeKeywords(keywords);
		if (keywords == null || keywords.isEmpty())
			this.keywords = null;
		else
			this.keywords = keywords;
	}

	/**
	 * Normalizes the keywords, this means, it will be trimmed and converted to
	 * lower case. Empty or null keywords are removed.
	 * 
	 * @param keywords The keywords to normalize.
	 * @return The normalized keywords. Null if the ginen collection is null.
	 * @since 1.8
	 */
	public static Set<String> normalizeKeywords(Collection<String> keywords) {
		if (keywords == null)
			return null;
		else {
			Set<String> normalized = new HashSet<>();

			for (String keyword : keywords)
				if (keyword != null && !keyword.isBlank())
					normalized.add(keyword.trim().toLowerCase());

			return normalized;
		}

	}

}
