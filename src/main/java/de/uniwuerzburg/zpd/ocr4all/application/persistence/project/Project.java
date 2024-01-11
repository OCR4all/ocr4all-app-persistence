/**
 * File:     Project.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.project
 *
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     10.05.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.project;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Keyword;

/**
 * Defines projects.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Project extends Keyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Defines project states.
	 * <ul>
	 * <li>active: all operations are allowed</li>
	 * <li>closed: no spi can be executed</li>
	 * <li>blocked: like closed, but in the server profile only administrators or
	 * coordinators can select the project and thus their models</li>
	 * </ul>
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum State {
		/**
		 * Active state
		 */
		active,
		/**
		 * Closed state
		 */
		closed,
		/**
		 * Blocked state
		 */
		blocked
	}

	/**
	 * The name.
	 */
	private String name = null;

	/**
	 * The description.
	 */
	private String description = null;

	/**
	 * The subfolder for exchange.
	 */
	private String exchange = null;

	/**
	 * The security.
	 */
	private Security security = null;

	/**
	 * The state.
	 */
	private State state = null;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The done time.
	 */
	private Date done = null;

	/**
	 * Default constructor for a project.
	 *
	 * @since 1.8
	 */
	public Project() {
		super();
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
	 * Returns the subfolder for exchange.
	 *
	 * @return The subfolder for exchange.
	 * @since 1.8
	 */
	public String getExchange() {
		return exchange;
	}

	/**
	 * Set the subfolder for exchange.
	 *
	 * @param folder The subfolder to set.
	 * @since 1.8
	 */
	public void setExchange(String folder) {
		exchange = folder;
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
	 * Returns the state.
	 *
	 * @return The state.
	 * @since 1.8
	 */
	public State getState() {
		return state;
	}

	/**
	 * Set the state.
	 *
	 * @param state The state to set.
	 * @since 1.8
	 */
	public void setState(State state) {
		this.state = state;
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
	 * Returns the done time.
	 *
	 * @return The done time.
	 * @since 1.8
	 */
	public Date getDone() {
		return done;
	}

	/**
	 * Set the done time.
	 *
	 * @param done The done time to set.
	 * @since 1.8
	 */
	public void setDone(Date done) {
		this.done = done;
	}

	/**
	 * Defines securities for projects.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public static class Security {
		/**
		 * The user grants.
		 */
		private Set<Grant> users;

		/**
		 * The groups grants.
		 */
		private Set<Grant> groups;

		/**
		 * The other rights.
		 */
		private Right other = null;

		/**
		 * Default constructor for project securities.
		 *
		 * @since 1.8
		 */
		public Security() {
			super();
		}

		/**
		 * Filter the grants, this means, remove the null items.
		 *
		 * @param grants The grants to filter.
		 * @return The filtered grants.
		 * @since 1.8
		 */
		private Set<Grant> filter(Set<Grant> grants) {
			if (grants == null)
				return null;
			else {
				Set<Grant> security = new HashSet<>();

				for (Grant grant : grants)
					if (grant != null)
						security.add(grant);

				return security;
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
			users = filter(grants);
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
			groups = filter(grants);
		}

		/**
		 * Returns the other rights.
		 *
		 * @return The other rights.
		 * @since 1.8
		 */
		public Right getOther() {
			return other;
		}

		/**
		 * Set the other rights.
		 *
		 * @param rights The rights to set.
		 * @since 1.8
		 */
		public void setOther(Right rights) {
			other = rights;
		}

		/**
		 * Defines rights for securities.
		 *
		 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
		 * @version 1.0
		 * @since 1.8
		 */
		public static class Right {
			/**
			 * True if read right is available.
			 */
			private boolean isRead = false;

			/**
			 * True if write right is available.
			 */
			private boolean isWrite = false;

			/**
			 * True if execute right is available.
			 */
			private boolean isExecute = false;

			/**
			 * True if special right is available.
			 */
			private boolean isSpecial = false;

			/**
			 * Returns true if read right is available.
			 *
			 * @return True if read right is available.
			 * @since 1.8
			 */
			public boolean isRead() {
				return isRead;
			}

			/**
			 * Set to true if read right is available.
			 *
			 * @param isRead The read right flag to set.
			 * @since 1.8
			 */
			public void setRead(boolean isRead) {
				this.isRead = isRead;
			}

			/**
			 * Returns true if write right is available.
			 *
			 * @return True if write right is available.
			 * @since 1.8
			 */
			public boolean isWrite() {
				return isWrite;
			}

			/**
			 * Set to true if write right is available.
			 *
			 * @param isWrite The write right flag to set.
			 * @since 1.8
			 */
			public void setWrite(boolean isWrite) {
				this.isWrite = isWrite;
			}

			/**
			 * Returns true if execute right is available.
			 *
			 * @return True if execute right is available.
			 * @since 1.8
			 */
			public boolean isExecute() {
				return isExecute;
			}

			/**
			 * Set to true if execute right is available.
			 *
			 * @param isExecute The execute right flag to set.
			 * @since 1.8
			 */
			public void setExecute(boolean isExecute) {
				this.isExecute = isExecute;
			}

			/**
			 * Returns true if special right is available.
			 *
			 * @return True if special right is available.
			 * @since 1.8
			 */
			public boolean isSpecial() {
				return isSpecial;
			}

			/**
			 * Set to true if special right is available.
			 *
			 * @param isSpecial The special right flag to set.
			 * @since 1.8
			 */
			public void setSpecial(boolean isSpecial) {
				this.isSpecial = isSpecial;
			}

		}

		/**
		 * Defines grants for securities.
		 *
		 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
		 * @version 1.0
		 * @since 1.8
		 */
		public static class Grant extends Right {
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
				if (targets == null)
					this.targets = null;
				else {
					Set<String> objectives = new HashSet<String>();

					for (String target : targets)
						if (target != null && !target.isBlank())
							objectives.add(target.trim().toLowerCase());

					this.targets = objectives;
				}
			}
		}
	}
}
