/**
 * File:     Repository.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.repository
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     23.11.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Tracking;

/**
 * Defines repositories.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Repository extends Tracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The security.
	 */
	private Security security = null;

	/**
	 * Default constructor for a repository.
	 * 
	 * @since 1.8
	 */
	public Repository() {
		super();
	}

	/**
	 * Creates a repository with current created and updated time.
	 * 
	 * @param user
	 * @since 1.8
	 */
	public Repository(String user) {
		super(new Date(), user);

		updated = getDate();
	}

	/**
	 * Creates a repository.
	 * 
	 * @param created The created time.
	 * @param updated The updated time. If null, uses the created time.
	 * @param user    The user.
	 * @since 1.8
	 */
	public Repository(Date created, Date updated, String user) {
		super(created, user);

		this.updated = updated;
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
	 * Returns the security.
	 *
	 * @return The security.
	 * @since 1.8
	 */
	public Security getSecurity() {
		return security;
	}

	/**
	 * Set the security.
	 *
	 * @param security The security to set.
	 * @since 1.8
	 */
	public void setSecurity(Security security) {
		this.security = security;
	}

	/**
	 * Defines securities for repositories.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public static class Security implements Serializable {
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
		 * Default constructor for repository securities.
		 * 
		 * @since 1.8
		 */
		public Security() {
			super();
		}

		/**
		 * Creates repository securities.
		 * 
		 * @param isSecured True if the repository is secured.
		 * @param users     The users.
		 * @param groups    The groups.
		 * @since 1.8
		 */
		public Security(boolean isSecured, Set<String> users, Set<String> groups) {
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
}
