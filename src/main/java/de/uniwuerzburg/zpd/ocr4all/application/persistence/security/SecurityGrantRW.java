/**
 * File:     SecurityGrant.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.security
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     22.05.2024
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.security;

import java.util.Set;

/**
 * Defines read/write securities with grants.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 17
 */
public class SecurityGrantRW extends SecurityGrantCore<SecurityGrantRW.Right> {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

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
		write;

		/**
		 * Set maximum rights
		 */
		public static Right maximal = write;

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
	 * Default constructor for read/write securities with grants.
	 *
	 * @since 1.8
	 */
	public SecurityGrantRW() {
		super();
	}

	/**
	 * Creates read/write securities with grants.
	 *
	 * @param right The right.
	 * @param user  The user.
	 * @since 1.8
	 */
	public SecurityGrantRW(Right right, String user) {
		super(right, user);
	}

	/**
	 * Creates read/write securities with grants.
	 *
	 * @param users  The user grants.
	 * @param groups The group grants.
	 * @param other  The other right.
	 * @since 17
	 */
	public SecurityGrantRW(Set<Grant<Right>> users, Set<Grant<Right>> groups, Right other) {
		super(users, groups, other);
	}
}
