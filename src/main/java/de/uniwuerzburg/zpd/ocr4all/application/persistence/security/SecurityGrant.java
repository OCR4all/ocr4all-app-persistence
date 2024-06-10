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
 * Defines securities with grants.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class SecurityGrant implements Serializable {
	/**
	 * Defines rights. The order of the elements is defined in ascending order to
	 * the right.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum Right {
		/**
		 * Read rights
		 */
		read,
		/**
		 * Write rights
		 */
		write,
		/**
		 * Special rights
		 */
		special;

		/**
		 * Set maximum rights
		 */
		public static Right maximal = special;

		/**
		 * Returns true if the target right is fulfilled.
		 *
		 * @param target The target right.
		 * @return True if the target right is fulfilled.
		 * @since 1.8
		 */
		public boolean iFulfilled(Right target) {
			return target != null && this.ordinal() >= target.ordinal();
		}

		/**
		 * Returns true if the read right is fulfilled.
		 *
		 * @return True if the read right is fulfilled.
		 * @since 1.8
		 */
		public boolean isReadFulfilled() {
			return iFulfilled(read);
		}

		/**
		 * Returns true if the write right is fulfilled.
		 *
		 * @return True if the write right is fulfilled.
		 * @since 1.8
		 */
		public boolean isWriteFulfilled() {
			return iFulfilled(write);
		}

		/**
		 * Returns true if the special right is fulfilled.
		 *
		 * @return True if the special right is fulfilled.
		 * @since 1.8
		 */
		public boolean isSpecialFulfilled() {
			return iFulfilled(special);
		}

		/**
		 * Returns true if the maximal right is fulfilled.
		 *
		 * @return True if the maximal right is fulfilled.
		 * @since 1.8
		 */
		public boolean isMaximalFulfilled() {
			return iFulfilled(maximal);
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
	 * Default constructor for securities with grants.
	 *
	 * @since 1.8
	 */
	public SecurityGrant() {
		super();
	}

	/**
	 * Creates securities with grants.
	 *
	 * @param right The right.
	 * @param user  The user.
	 * @since 1.8
	 */
	public SecurityGrant(Right right, String user) {
		super();

		if (user != null && !user.isBlank() && right != null) {
			Set<Grant> grants = new HashSet<>();
			grants.add(new Grant(right, user));
			setUsers(grants);
		}
	}

	/**
	 * Creates securities with grants.
	 *
	 * @param users  The user grants.
	 * @param groups The group grants.
	 * @param other  The other right.
	 * @since 1.8
	 */
	public SecurityGrant(Set<Grant> users, Set<Grant> groups, Right other) {
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
		Set<Grant> objectives = new HashSet<>();

		if (grants != null)
			for (Grant grant : grants)
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
		 * @param right  The right.
		 * @param target The target.
		 * @since 1.8
		 */
		public Grant(Right right, String target) {
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
		public Grant(Right right, Set<String> targets) {
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
