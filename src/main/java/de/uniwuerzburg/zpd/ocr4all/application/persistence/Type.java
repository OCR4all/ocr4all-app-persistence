/**
 * File:     Type.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     18.03.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.job.ProcessHistory;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.project.ActionHistory;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.project.Folio;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.project.Project;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.project.sandbox.Snapshot;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.project.sandbox.Sandbox;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.spi.DisabledServiceProvider;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.spi.LazyInitializedServiceProvider;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.spi.TaskExecutorServiceProvider;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow.Metadata;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow.View;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.workflow.Workflow;

/**
 * Defines persistence types.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public enum Type {
	job_process_v1(de.uniwuerzburg.zpd.ocr4all.application.persistence.job.Process.class),
	job_process_history_v1(ProcessHistory.class),

	workflow_v1(Workflow.class), workflow_metadata_v1(Metadata.class), workflow_view_v1(View.class),

	project_v1(Project.class), project_folio_v1(Folio.class), project_sandbox_v1(Sandbox.class),
	project_sandbox_snapshot_v1(Snapshot.class), project_action_history_v1(ActionHistory.class),

	service_provider_disabled_v1(DisabledServiceProvider.class),
	service_provider_lazy_initialized_v1(LazyInitializedServiceProvider.class),
	service_provider_task_executor_v1(TaskExecutorServiceProvider.class);

	/**
	 * The class for the persistence type.
	 */
	private final Class<? extends Entity> clazz;

	/**
	 * Creates a persistence type.
	 * 
	 * @param clazz The class for the type.
	 * @since 1.8
	 */
	private Type(Class<? extends Entity> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Returns the class for the type.
	 *
	 * @return The class for the type.
	 * @since 1.8
	 */
	public Class<? extends Entity> getTypeClass() {
		return clazz;
	}

	/**
	 * Returns the type for given class.
	 * 
	 * @param clazz The class.
	 * @return The type for given class. Null if unknown.
	 * @since 1.8
	 */
	public static Type getType(Class<? extends Entity> clazz) {
		if (clazz != null)
			for (Type entity : Type.values())
				if (entity.getTypeClass().equals(clazz))
					return entity;

		return null;
	}
}
