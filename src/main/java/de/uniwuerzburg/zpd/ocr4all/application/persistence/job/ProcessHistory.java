/**
 * File:     ProcessHistory.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.job
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     26.03.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.job;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Instance;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.project.ProjectHistory;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.spi.ServiceProvider;

/**
 * Defines process histories.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class ProcessHistory extends ProjectHistory {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Defines actions.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum Action {
		startet, completed, canceled, interrupted
	}

	/**
	 * The instance.
	 */
	private Instance instance;

	/**
	 * The action.
	 */
	private Action action = null;

	/**
	 * The job number. 0 if not set.
	 */
	private int job = 0;

	/**
	 * The number of steps. 0 if not set.
	 */
	private int steps = 0;

	/**
	 * The step. 0 if not set.
	 */
	private int step = 0;

	/**
	 * The progress. This is a value between 0 and 1 inclusive. The initial value is
	 * 0.
	 */
	private float progress = 0;

	/**
	 * The standard output message. Null if not set.
	 */
	private String standardOutput = null;

	/**
	 * The standard error message. Null if not set.
	 */
	private String standardError = null;

	/**
	 * The service provider.
	 */
	@JsonProperty("service-provider")
	private ServiceProviderHistory serviceProvider;

	/**
	 * The note.
	 */
	private String note = null;

	/**
	 * Default constructor for a process history with level info.
	 * 
	 * @since 1.8
	 */
	public ProcessHistory() {
		super();
	}

	/**
	 * Creates a process history.
	 * 
	 * @param level                      The level. If it is null, then info is
	 *                                   used.
	 * @param instance                   The instance.
	 * @param action                     The action.
	 * @param job                        The job number. 0 if not set.
	 * @param steps                      The number of steps. 0 if not set.
	 * @param step                       The step. 0 if not set.
	 * @param progress                   The progress. This is a value between 0 and
	 *                                   1 inclusive. The initial value is 0.
	 * @param standardOutput             The standard output message. Null if not
	 *                                   set.
	 * @param standardError              The standard error message. Null if not
	 *                                   set.
	 * @param serviceProvider            The service provider.
	 * @param serviceProviderName        The service provider name.
	 * @param serviceProviderVersion     The service provider version. It is a
	 *                                   positive number. 0 if not set.
	 * @param serviceProviderDescription The service provider description.
	 * @param note                       The note.
	 * @since 1.8
	 */
	public ProcessHistory(Level level, Instance instance, Action action, int job, int steps, int step, float progress,
			String standardOutput, String standardError, ServiceProvider serviceProvider, String serviceProviderName,
			float serviceProviderVersion, String serviceProviderDescription, String note) {
		super(level);

		this.instance = instance;

		setAction(action);
		setJob(job);
		setSteps(steps);
		setStep(step);
		setProgress(progress);
		setStandardOutput(standardOutput);
		setStandardError(standardError);

		this.serviceProvider = new ServiceProviderHistory(serviceProvider, serviceProviderName, serviceProviderVersion,
				serviceProviderDescription);

		setNote(note);
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
	 * Returns the action.
	 *
	 * @return The action.
	 * @since 1.8
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Set the action.
	 *
	 * @param action The action to set.
	 * @since 1.8
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * Returns the job number. 0 if not set.
	 *
	 * @return The job number.
	 * @since 1.8
	 */
	public int getJob() {
		return job;
	}

	/**
	 * Set the job number.
	 *
	 * @param number The job number to set. 0 if not set.
	 * @since 1.8
	 */
	public void setJob(int number) {
		if (number > 0)
			job = number;
		else
			job = 0;
	}

	/**
	 * Returns the steps. 0 if not set.
	 *
	 * @return The steps.
	 * @since 1.8
	 */
	public int getSteps() {
		return steps;
	}

	/**
	 * Set the steps.
	 *
	 * @param steps The steps to set. 0 if not set.
	 * @since 1.8
	 */
	public void setSteps(int steps) {
		if (steps > 0)
			this.steps = steps;
		else
			this.steps = 0;
	}

	/**
	 * Returns the step. 0 if not set.
	 *
	 * @return The step.
	 * @since 1.8
	 */
	public int getStep() {
		return step;
	}

	/**
	 * Set the step.
	 *
	 * @param step The step to set. 0 if not set.
	 * @since 1.8
	 */
	public void setStep(int step) {
		if (step > 0)
			this.step = step;
		else
			this.step = 0;
	}

	/**
	 * Returns the progress. This is a progress between 0 and 1 inclusive.
	 *
	 * @return The progress.
	 * @since 1.8
	 */
	public float getProgress() {
		return progress;
	}

	/**
	 * Set the progress. This is a progress between 0 and 1 inclusive.
	 *
	 * @param progress The progress to set.
	 * @since 1.8
	 */
	public void setProgress(float progress) {
		if (progress >= 1)
			this.progress = 1;
		else if (progress <= 0)
			this.progress = 0;
		else
			this.progress = progress;
	}

	/**
	 * Returns the standard output message. Null if not set.
	 *
	 * @return The standard output message.
	 * @since 1.8
	 */
	public String getStandardOutput() {
		return standardOutput;
	}

	/**
	 * Set the standard output message.
	 *
	 * @param message The message to set.
	 * @since 1.8
	 */
	public void setStandardOutput(String message) {
		standardOutput = message;
	}

	/**
	 * Returns the standard error message. Null if not set.
	 *
	 * @return The standard error.
	 * @since 1.8
	 */
	public String getStandardError() {
		return standardError;
	}

	/**
	 * Set the standard error message.
	 *
	 * @param message The message to set.
	 * @since 1.8
	 */
	public void setStandardError(String message) {
		standardError = message;
	}

	/**
	 * Returns the service provider.
	 *
	 * @return The service provider.
	 * @since 1.8
	 */
	public ServiceProviderHistory getServiceProvider() {
		return serviceProvider;
	}

	/**
	 * Set the service provider.
	 *
	 * @param serviceProvider The service provider to set.
	 * @since 1.8
	 */
	public void setServiceProvider(ServiceProviderHistory serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	/**
	 * Returns the note.
	 *
	 * @return The note.
	 * @since 1.8
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Set the note.
	 *
	 * @param note The note to set.
	 * @since 1.8
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Defines service provider histories.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public static class ServiceProviderHistory extends ServiceProvider {
		/**
		 * The serial version UID.
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * The name.
		 */
		private String name = null;

		/**
		 * The version. It is a positive number. 0 if not set.
		 */
		private float version = 0;

		/**
		 * The description.
		 */
		private String description = null;

		/**
		 * Default constructor for a service provider history.
		 * 
		 * @since 1.8
		 */
		public ServiceProviderHistory() {
			super();
		}

		/**
		 * Creates a service provider history.
		 * 
		 * @param serviceProvider The service provider.
		 * @param name            The name.
		 * @param version         The version. It is a positive number. 0 if not set.
		 * @param description     The description.
		 * @since 1.8
		 */
		public ServiceProviderHistory(ServiceProvider serviceProvider, String name, float version, String description) {
			super(serviceProvider);

			setName(name);
			setVersion(version);
			setDescription(description);
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
		 * Returns the version.
		 *
		 * @return The version.
		 * @since 1.8
		 */
		public float getVersion() {
			return version;
		}

		/**
		 * Set the version.
		 *
		 * @param version The version to set.
		 * @since 1.8
		 */
		public void setVersion(float version) {
			if (version <= 0)
				this.version = 0;
			else
				this.version = version;
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

	}
}
