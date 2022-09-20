/**
 * File:     Snapshot.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.project.workflow.snapshot
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     08.03.2022
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.project.workflow;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Instance;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.Tracking;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.spi.ServiceProvider;

/**
 * Defines workflow snapshots.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Snapshot extends Tracking {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Define types.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum Type {
		launcher, preprocessing, olr, ocr
	}

	/**
	 * The type.
	 */
	private Type type;

	/**
	 * The updated time.
	 */
	private Date updated = null;

	/**
	 * The label.
	 */
	private String label;

	/**
	 * The description.
	 */
	private String description;

	/**
	 * The service provider.
	 */
	@JsonProperty("service-provider")
	private ServiceProvider serviceProvider;

	/**
	 * The instance.
	 */
	private Instance instance;

	/**
	 * The lock.
	 */
	private Lock lock = null;

	/**
	 * Default constructor for a snapshot.
	 * 
	 * @since 1.8
	 */
	public Snapshot() {
		super();
	}

	/**
	 * Creates a snapshot with current created and updated time.
	 * 
	 * @param type            The type.
	 * @param label           The label.
	 * @param description     The description.
	 * @param serviceProvider The service provider.
	 * @param instance        The instance.
	 * @param user            The user.
	 * @since 1.8
	 */
	public Snapshot(Type type, String label, String description, ServiceProvider serviceProvider, Instance instance,
			String user) {
		this(type, label, description, serviceProvider, instance, new Date(), null, user, null);
	}

	/**
	 * Creates a snapshot.
	 * 
	 * @param type            The type.
	 * @param label           The label.
	 * @param description     The description.
	 * @param serviceProvider The service provider.
	 * @param instance        The instance.
	 * @param created         The created time.
	 * @param updated         The updated time. If null, uses the created time.
	 * @param user            The user.
	 * @param lock            The lock.
	 * @since 1.8
	 */
	public Snapshot(Type type, String label, String description, ServiceProvider serviceProvider, Instance instance,
			Date created, Date updated, String user, Lock lock) {
		super(created, user);

		this.type = type;

		this.label = label == null || label.isBlank() ? null : label.trim();
		this.description = description == null || description.isBlank() ? null : description.trim();

		this.serviceProvider = serviceProvider;
		this.instance = instance;

		this.updated = updated == null ? created : updated;
		this.lock = lock;
	}

	/**
	 * Returns the type.
	 *
	 * @return The type.
	 * @since 1.8
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Set the type.
	 *
	 * @param type The type to set.
	 * @since 1.8
	 */
	public void setType(Type type) {
		this.type = type;
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
	 * Returns the label.
	 *
	 * @return The label.
	 * @since 1.8
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Set the label.
	 *
	 * @param label The label to set.
	 * @since 1.8
	 */
	public void setLabel(String label) {
		this.label = label;
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
	 * Returns the service provider.
	 *
	 * @return The service provider.
	 * @since 1.8
	 */
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	/**
	 * Set the service provider.
	 *
	 * @param serviceProvider The service provider to set.
	 * @since 1.8
	 */
	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	/**
	 * Returns the instance.
	 *
	 * @return The instance.
	 * @since 1.8
	 */
	public Instance getInstance() {
		return instance;
	}

	/**
	 * Set the instance.
	 *
	 * @param instance The instance to set.
	 * @since 1.8
	 */
	public void setInstance(Instance instance) {
		this.instance = instance;
	}

	/**
	 * Returns the lock.
	 *
	 * @return The lock.
	 * @since 1.8
	 */
	public Lock getLock() {
		return lock;
	}

	/**
	 * Set the lock.
	 *
	 * @param lock The lock to set.
	 * @since 1.8
	 */
	public void setLock(Lock lock) {
		this.lock = lock;
	}

	/**
	 * Defines snapshot locks.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public static class Lock implements Serializable {
		/**
		 * The serial version UID.
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * The source.
		 */
		private String source = null;

		/**
		 * The comment.
		 */
		private String comment = null;

		/**
		 * The created time.
		 */
		private Date created = null;

		/**
		 * Default constructor for a snapshot lock.
		 * 
		 * @since 1.8
		 */
		public Lock() {
			super();
		}

		/**
		 * Creates a snapshot lock with current created time.
		 * 
		 * @param source  The source.
		 * @param comment The comment.
		 * @since 1.8
		 */
		public Lock(String source, String comment) {
			super();

			this.source = source == null ? null : source.trim();
			this.comment = comment == null ? null : comment.trim();

			this.created = new Date();
		}

		/**
		 * Returns the source.
		 *
		 * @return The source.
		 * @since 1.8
		 */
		public String getSource() {
			return source;
		}

		/**
		 * Set the source.
		 *
		 * @param source The source to set.
		 * @since 1.8
		 */
		public void setSource(String source) {
			this.source = source;
		}

		/**
		 * Returns the comment.
		 *
		 * @return The comment.
		 * @since 1.8
		 */
		public String getComment() {
			return comment;
		}

		/**
		 * Set the comment.
		 *
		 * @param comment The comment to set.
		 * @since 1.8
		 */
		public void setComment(String comment) {
			this.comment = comment;
		}

		/**
		 * Returns the created time.
		 *
		 * @return The created time.
		 * @since 1.8
		 */
		public Date getCreated() {
			return created;
		}

		/**
		 * Set the created time.
		 *
		 * @param created The created time to set.
		 * @since 1.8
		 */
		public void setCreated(Date created) {
			this.created = created;
		}

	}
}
