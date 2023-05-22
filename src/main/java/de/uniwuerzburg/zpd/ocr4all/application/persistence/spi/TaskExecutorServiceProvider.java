/**
 * File:     TaskExecutorServiceProvider.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.spi
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     22.05.2023
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.spi;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Identifier;

/**
 * Defines task executor service providers.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class TaskExecutorServiceProvider extends Identifier {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The thread name.
	 */
	private String threadName = null;

	/**
	 * The core pool size. The value must be greater than 0. Default is 1.
	 */
	private int corePoolSize = 1;

	/**
	 * Default constructor for a task executor service provider.
	 * 
	 * @since 1.8
	 */
	public TaskExecutorServiceProvider() {
		super();
	}

	/**
	 * Creates a task executor service provider with current date.
	 * 
	 * @param user         The user.
	 * @param id           The service provider id.
	 * @param threadName   The thread name. It is be trimmed.
	 * @param corePoolSize The core pool size. The value must be greater than 0.
	 * @since 1.8
	 */
	public TaskExecutorServiceProvider(String user, String id, String threadName, int corePoolSize) {
		super(user, id);

		setThreadName(threadName);
		setCorePoolSize(corePoolSize);
	}

	/**
	 * Returns the thread name.
	 *
	 * @return The thread name.
	 * @since 1.8
	 */
	public String getThreadName() {
		return threadName;
	}

	/**
	 * Set the thread name if not null or empty.
	 *
	 * @param threadName The thread name to set. It is be trimmed.
	 * @since 1.8
	 */
	public void setThreadName(String threadName) {
		if (threadName != null && !threadName.isBlank())
			this.threadName = threadName.trim();
	}

	/**
	 * Returns the core pool size.
	 *
	 * @return The core pool size.
	 * @since 1.8
	 */
	public int getCorePoolSize() {
		return corePoolSize;
	}

	/**
	 * Set the core pool size if it is greater than 0.
	 *
	 * @param corePoolSize The core pool size to set.
	 * @since 1.8
	 */
	public void setCorePoolSize(int corePoolSize) {
		if (corePoolSize > 0)
			this.corePoolSize = corePoolSize;
	}

}
