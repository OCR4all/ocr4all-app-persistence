/**
 * File:     SecurityOwner.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.security
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     22.05.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Defines securities for owners.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class SecurityOwner implements Serializable {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * True if the repository is secured.
	 */
	private boolean isSecured = false;

	/**
	 * The users.
	 */
	private Set<String> users;

	/**
	 * The groups.
	 */
	private Set<String> groups;

	/**
	 * Default constructor for owner securities.
	 * 
	 * @since 1.8
	 */
	public SecurityOwner() {
		super();
	}

	/**
	 * Creates owner securities.
	 * 
	 * @param isSecured True if the repository is secured.
	 * @param users     The users.
	 * @param groups    The groups.
	 * @since 1.8
	 */
	public SecurityOwner(boolean isSecured, Set<String> users, Set<String> groups) {
		super();

		this.isSecured = isSecured;

		setUsers(users);
		setGroups(groups);
	}

	/**
	 * Returns true if the repository is secured.
	 *
	 * @return True if the repository is secured.
	 * @since 1.8
	 */
	public boolean isSecured() {
		return isSecured;
	}

	/**
	 * Set to true if the repository is secured.
	 *
	 * @param isSecured The secured flag to set.
	 * @since 1.8
	 */
	public void setSecured(boolean isSecured) {
		this.isSecured = isSecured;
	}

	/**
	 * Filter the targets, this means, remove the null and empty items. The items
	 * are trimmed and converts all of the characters to lower case.
	 * 
	 * @param targets The targets to filter.
	 * @return The filtered targets.
	 * @since 1.8
	 */
	private Set<String> filter(Set<String> targets) {
		if (targets == null)
			return null;
		else {
			Set<String> security = new HashSet<>();

			for (String target : targets)
				if (target != null && !target.isBlank())
					security.add(target.trim().toLowerCase());

			return security;
		}
	}

	/**
	 * Returns the users.
	 *
	 * @return The users.
	 * @since 1.8
	 */
	public Set<String> getUsers() {
		return users;
	}

	/**
	 * Set the users.
	 *
	 * @param users The users to set.
	 * @since 1.8
	 */
	public void setUsers(Set<String> users) {
		this.users = filter(users);
	}

	/**
	 * Returns the groups.
	 *
	 * @return The groups.
	 * @since 1.8
	 */
	public Set<String> getGroups() {
		return groups;
	}

	/**
	 * Set the groups.
	 *
	 * @param groups The groups to set.
	 * @since 1.8
	 */
	public void setGroups(Set<String> groups) {
		this.groups = filter(groups);
	}

}
