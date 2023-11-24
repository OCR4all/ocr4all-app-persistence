/**
 * File:     Container.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.repository
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     24.11.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Keyword;

/**
 * Defines containers.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Container extends Keyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The name.
	 */
	private String name = null;

	/**
	 * The description.
	 */
	private String description = null;

	/**
	 * The security.
	 */
	private Security security = null;

	/**
	 * Default constructor for a container.
	 * 
	 * @since 1.8
	 */
	public Container() {
		super();
	}

	/**
	 * Creates a container with current created and updated time.
	 * 
	 * @param user
	 * @since 1.8
	 */
	public Container(String user) {
		super(new Date(), user);

		updated = getDate();
	}

	/**
	 * Creates a container.
	 * 
	 * @param created     The created time.
	 * @param updated     The updated time. If null, uses the created time.
	 * @param user        The user.
	 * @param name        The name.
	 * @param description The description.
	 * @param security    The security.
	 * @since 1.8
	 */
	public Container(Date created, Date updated, String user, String name, String description, Security security) {
		super(created, user);

		this.updated = updated;
		this.name = name;
		this.description = description;
		this.security = security;
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
	 * Returns the name.
	 *
	 * @return The name.
	 * @since 1.8
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name.
	 *
	 * @param name The name to set.
	 * @since 1.8
	 */
	public void setName(String name) {
		this.name = name;
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
		 * Defines rights.
		 *
		 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
		 * @version 1.0
		 * @since 1.8
		 */
		public enum Right {
			read, write, special;

			/**
			 * Returns the maximal right.
			 * 
			 * @return The maximal right.
			 * @since 1.8
			 */
			public static Right getMaximal() {
				return special;
			}

			/**
			 * Returns the maximal right.
			 * 
			 * @param r1 The right.
			 * @param r2 The right.
			 * @return The maximal right.
			 * @since 1.8
			 */
			public static Right getMaximnal(Right r1, Right r2) {
				return r1 == null ? r2 : (r2 == null ? r1 : (r1.ordinal() > r2.ordinal() ? r1 : r2));
			}
		}

		/**
		 * The serial version UID.
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * The user grants.
		 */
		private Set<Grant> users;

		/**
		 * The group grants.
		 */
		private Set<Grant> groups;

		/**
		 * The other right.
		 */
		private Right other = null;

		/**
		 * Default constructor for a container securities.
		 * 
		 * @since 1.8
		 */
		public Security() {
			super();
		}

		/**
		 * Creates a container securities.
		 * 
		 * @param user  The user.
		 * @param right The right.
		 * @since 1.8
		 */
		public Security(String user, Right right) {
			super();

			if (user != null && !user.isBlank() && right != null) {
				users = new HashSet<>();
				users.add(new Grant(user, right));
			}
		}

		/**
		 * Creates a container securities.
		 * 
		 * @param users  The user grants.
		 * @param groups The group grants.
		 * @param other  The other right.
		 * @since 1.8
		 */
		public Security(Set<Grant> users, Set<Grant> groups, Right other) {
			super();

			setUsers(users);
			setGroups(groups);

			this.other = other;
		}

		/**
		 * Filter the grants, this means, remove the null and the item, whose right or
		 * targets is null.
		 * 
		 * @param grants The grants to filter.
		 * @return The filtered grants.
		 * @since 1.8
		 */
		private Set<Grant> filter(Set<Grant> grants) {
			if (grants == null)
				return null;
			else {
				Set<Grant> objectives = new HashSet<>();

				for (Grant grant : grants)
					if (grant != null && grant.getRight() != null && grant.getTargets() != null)
						objectives.add(grant);

				return objectives;
			}
		}

		/**
		 * Returns the user grants.
		 *
		 * @return The user grants.
		 * @since 1.8
		 */
		public Set<Grant> getUsers() {
			return users;
		}

		/**
		 * Set the user grants.
		 *
		 * @param grants The grants to set.
		 * @since 1.8
		 */
		public void setUsers(Set<Grant> grants) {
			this.users = filter(grants);
		}

		/**
		 * Returns the group grants.
		 *
		 * @return The group grants.
		 * @since 1.8
		 */
		public Set<Grant> getGroups() {
			return groups;
		}

		/**
		 * Set the group grants.
		 *
		 * @param grants The grants to set.
		 * @since 1.8
		 */
		public void setGroups(Set<Grant> grants) {
			this.groups = filter(grants);
		}

		/**
		 * Returns the other right.
		 *
		 * @return The other right.
		 * @since 1.8
		 */
		public Right getOther() {
			return other;
		}

		/**
		 * Set the other right.
		 *
		 * @param right The right to set.
		 * @since 1.8
		 */
		public void setOther(Right right) {
			other = right;
		}

		/**
		 * Defines grants for securities.
		 *
		 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
		 * @version 1.0
		 * @since 1.8
		 */
		public static class Grant implements Serializable {
			/**
			 * The serial version UID.
			 */
			private static final long serialVersionUID = 1L;

			/**
			 * The right.
			 */
			private Right right = null;

			/**
			 * The targets.
			 */
			private Set<String> targets;

			/**
			 * Default constructor for a grant.
			 * 
			 * @since 1.8
			 */
			public Grant() {
				super();
			}

			/**
			 * Creates a grant.
			 * 
			 * @param target The target.
			 * @param right  The right.
			 * @since 1.8
			 */
			public Grant(String target, Right right) {
				super();

				this.right = right;

				targets = new HashSet<>();
				targets.add(target.trim().toLowerCase());
			}

			/**
			 * Returns the right.
			 *
			 * @return The right.
			 * @since 1.8
			 */
			public Right getRight() {
				return right;
			}

			/**
			 * Set the right.
			 *
			 * @param right The right to set.
			 * @since 1.8
			 */
			public void setRight(Right right) {
				this.right = right;
			}

			/**
			 * Returns the targets.
			 *
			 * @return The targets.
			 * @since 1.8
			 */
			public Set<String> getTargets() {
				return targets;
			}

			/**
			 * Set the targets.
			 *
			 * @param targets The targets to set.
			 * @since 1.8
			 */
			public void setTargets(Set<String> targets) {
				Set<String> objectives = new HashSet<String>();

				for (String target : targets)
					if (target != null && !target.isBlank())
						objectives.add(target.trim().toLowerCase());

				this.targets = objectives;
			}
		}
	}
}
