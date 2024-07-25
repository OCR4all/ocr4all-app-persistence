/**
 * File:     SecurityGrant.java
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
 * Defines core securities with grants.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class SecurityGrantCore<R extends Enum<?>> implements Serializable {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The user grants.
	 */
	private Set<Grant<R>> users;

	/**
	 * The group grants.
	 */
	private Set<Grant<R>> groups;

	/**
	 * The other right.
	 */
	private R other = null;

	/**
	 * Default constructor for core securities with grants.
	 *
	 * @since 1.8
	 */
	public SecurityGrantCore() {
		super();
	}

	/**
	 * Creates core securities with grants.
	 *
	 * @param right The right.
	 * @param user  The user.
	 * @since 1.8
	 */
	public SecurityGrantCore(R right, String user) {
		super();

		if (user != null && !user.isBlank() && right != null) {
			Set<Grant<R>> grants = new HashSet<>();
			grants.add(new Grant<R>(right, user));
			setUsers(grants);
		}
	}

	/**
	 * Creates core securities with grants.
	 *
	 * @param users  The user grants.
	 * @param groups The group grants.
	 * @param other  The other right.
	 * @since 1.8
	 */
	public SecurityGrantCore(Set<Grant<R>> users, Set<Grant<R>> groups, R other) {
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
	private Set<Grant<R>> filter(Set<Grant<R>> grants) {
		Set<Grant<R>> objectives = new HashSet<>();

		if (grants != null)
			for (Grant<R> grant : grants)
				if (grant != null && grant.getRight() != null && grant.getTargets() != null)
					objectives.add(grant);

		return objectives.isEmpty() ? null : objectives;
	}

	/**
	 * Returns the user grants.
	 *
	 * @return The user grants.
	 * @since 1.8
	 */
	public Set<Grant<R>> getUsers() {
		return users;
	}

	/**
	 * Set the user grants.
	 *
	 * @param grants The grants to set.
	 * @since 1.8
	 */
	public void setUsers(Set<Grant<R>> grants) {
		this.users = filter(grants);
	}

	/**
	 * Returns the group grants.
	 *
	 * @return The group grants.
	 * @since 1.8
	 */
	public Set<Grant<R>> getGroups() {
		return groups;
	}

	/**
	 * Set the group grants.
	 *
	 * @param grants The grants to set.
	 * @since 1.8
	 */
	public void setGroups(Set<Grant<R>> grants) {
		this.groups = filter(grants);
	}

	/**
	 * Returns the other right.
	 *
	 * @return The other right.
	 * @since 1.8
	 */
	public R getOther() {
		return other;
	}

	/**
	 * Set the other right.
	 *
	 * @param right The right to set.
	 * @since 1.8
	 */
	public void setOther(R right) {
		other = right;
	}

	/**
	 * Defines grants for securities.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public static class Grant<R extends Enum<?>> implements Serializable {
		/**
		 * The serial version UID.
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * The right.
		 */
		private R right = null;

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
		 * @param right  The right.
		 * @param target The target.
		 * @since 1.8
		 */
		public Grant(R right, String target) {
			super();

			this.right = right;

			Set<String> targets = new HashSet<>();
			targets.add(target);
			setTargets(targets);
		}

		/**
		 * Creates a grant.
		 *
		 * @param right   The right.
		 * @param targets The targets.
		 * @since 1.8
		 */
		public Grant(R right, Set<String> targets) {
			super();

			this.right = right;
			setTargets(targets);
		}

		/**
		 * Returns the right.
		 *
		 * @return The right.
		 * @since 1.8
		 */
		public R getRight() {
			return right;
		}

		/**
		 * Set the right.
		 *
		 * @param right The right to set.
		 * @since 1.8
		 */
		public void setRight(R right) {
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
			this.targets = new HashSet<>();
			Set<String> objectives = new HashSet<String>();

			if (targets != null)
				for (String target : targets)
					if (target != null && !target.isBlank())
						objectives.add(target.trim().toLowerCase());

			this.targets = objectives.isEmpty() ? null : objectives;
		}
	}

}
