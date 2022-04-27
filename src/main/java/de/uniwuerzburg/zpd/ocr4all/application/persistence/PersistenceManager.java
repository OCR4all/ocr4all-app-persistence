/**
 * File:     PersistenceManager.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     18.03.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Defines persistence managers.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class PersistenceManager {
	/**
	 * The JSON object mapper.
	 */
	private final ObjectMapper objectMapper = new ObjectMapper();
	{
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * The default repository. Null if no default repository is defined.
	 */
	private final Path repository;

	/**
	 * The persistence types.
	 */
	private final Set<Type> types = new HashSet<>();

	/**
	 * Creates a persistence manager without default repository.
	 * 
	 * @param types The types.
	 * @throws IllegalArgumentException Throws when no types are present.
	 * @since 1.8
	 */
	public PersistenceManager(Type... types) throws IllegalArgumentException {
		this(null, types);
	}

	/**
	 * Creates a persistence manager.
	 * 
	 * @param repository The default repository. Null if no default repository is
	 *                   defined.
	 * @param types      The types.
	 * @throws IllegalArgumentException Throws when no types are present.
	 * @since 1.8
	 */
	public PersistenceManager(Path repository, Type... types) throws IllegalArgumentException {
		super();

		this.repository = repository;

		// The types
		for (Type type : types)
			if (type != null)
				this.types.add(type);

		if (this.types.isEmpty())
			throw new IllegalArgumentException("PersistenceManager: no types are available.");
	}

	/**
	 * Persist the entities to the default repository. The repository is truncated
	 * before the entity is persisted.
	 * 
	 * @param <T>      The entity type.
	 * @param entities The entities to persist.
	 * @return The number of persisted entities.
	 * @throws NullPointerException          Throws if the no default repository is
	 *                                       defined.
	 * @throws UnsupportedOperationException Throws if no persistence type is
	 *                                       defined for an entity.
	 * @throws IllegalArgumentException      Throws if the persistence manager
	 *                                       doesn't supports the persistence type
	 *                                       of the given entities.
	 * @throws IOException                   Throws if an entity can not be
	 *                                       persisted.
	 * @since 1.8
	 */
	@SafeVarargs
	final public <T extends Entity> int persist(T... entities)
			throws NullPointerException, UnsupportedOperationException, IllegalArgumentException, IOException {
		return persist(false, entities);
	}

	/**
	 * Persist the entities to the default repository. The repository is truncated
	 * before the entity is persisted.
	 * 
	 * @param <T>      The entity type.
	 * @param entities The entities to persist.
	 * @return The number of persisted entities.
	 * @throws NullPointerException          Throws if the no default repository is
	 *                                       defined.
	 * @throws UnsupportedOperationException Throws if no persistence type is
	 *                                       defined for an entity.
	 * @throws IllegalArgumentException      Throws if the persistence manager
	 *                                       doesn't supports the persistence type
	 *                                       of the given entities.
	 * @throws IOException                   Throws if an entity can not be
	 *                                       persisted.
	 * @since 1.8
	 */
	public <T extends Entity> int persist(Collection<T> entities)
			throws NullPointerException, UnsupportedOperationException, IllegalArgumentException, IOException {
		return persist(false, entities);
	}

	/**
	 * Persist the entities to the default repository.
	 * 
	 * @param <T>      The entity type.
	 * @param isAppend True if the entities are written to the end of the
	 *                 repository. Otherwise, the repository is truncated before the
	 *                 entities are persisted.
	 * @param entities The entities to persist.
	 * @return The number of persisted entities.
	 * @throws NullPointerException          Throws if the no default repository is
	 *                                       defined.
	 * @throws UnsupportedOperationException Throws if no persistence type is
	 *                                       defined for an entity.
	 * @throws IllegalArgumentException      Throws if the persistence manager
	 *                                       doesn't supports the persistence type
	 *                                       of the given entities.
	 * @throws IOException                   Throws if an entity can not be
	 *                                       persisted.
	 * @since 1.8
	 */
	@SafeVarargs
	final public <T extends Entity> int persist(boolean isAppend, T... entities)
			throws NullPointerException, UnsupportedOperationException, IllegalArgumentException, IOException {
		return persist(null, isAppend, entities);
	}

	/**
	 * Persist the entities to the default repository.
	 * 
	 * @param <T>      The entity type.
	 * @param isAppend True if the entities are written to the end of the
	 *                 repository. Otherwise, the repository is truncated before the
	 *                 entities are persisted.
	 * @param entities The entities to persist.
	 * @return The number of persisted entities.
	 * @throws NullPointerException          Throws if the no default repository is
	 *                                       defined.
	 * @throws UnsupportedOperationException Throws if no persistence type is
	 *                                       defined for an entity.
	 * @throws IllegalArgumentException      Throws if the persistence manager
	 *                                       doesn't supports the persistence type
	 *                                       of the given entities.
	 * @throws IOException                   Throws if an entity can not be
	 *                                       persisted.
	 * @since 1.8
	 */
	public <T extends Entity> int persist(boolean isAppend, Collection<T> entities)
			throws NullPointerException, UnsupportedOperationException, IllegalArgumentException, IOException {
		return persist(null, isAppend, entities);
	}

	/**
	 * Persist the entity.
	 * 
	 * @param <T>        The entity type.
	 * @param repository The repository. If null, the default repository is used.
	 * @param isAppend   True if the entities are written to the end of the
	 *                   repository. Otherwise, the repository is truncated before
	 *                   the entities are persisted.
	 * @param entities   The entities to persist.
	 * @return The number of persisted entities.
	 * @throws NullPointerException          Throws if the no repository is defined.
	 * @throws UnsupportedOperationException Throws if no persistence type is
	 *                                       defined for an entity.
	 * @throws IllegalArgumentException      Throws if the persistence manager
	 *                                       doesn't supports the persistence type
	 *                                       of the given entities.
	 * @throws IOException                   Throws if an entity can not be
	 *                                       persisted.
	 * @since 1.8
	 */
	@SafeVarargs
	final public <T extends Entity> int persist(Path repository, boolean isAppend, T... entities)
			throws NullPointerException, UnsupportedOperationException, IllegalArgumentException, IOException {
		return persist(repository, isAppend, Arrays.asList(entities));
	}

	/**
	 * Persist the entities.
	 * 
	 * @param <T>        The entity type.
	 * @param repository The repository. If null, the default repository is used.
	 * @param isAppend   True if the entities are written to the end of the
	 *                   repository. Otherwise, the repository is truncated before
	 *                   the entities are persisted.
	 * @param entities   The entities to persist.
	 * @return The number of persisted entities.
	 * @throws NullPointerException          Throws if the no repository is defined.
	 * @throws UnsupportedOperationException Throws if no persistence type is
	 *                                       defined for an entity.
	 * @throws IllegalArgumentException      Throws if the persistence manager
	 *                                       doesn't supports the persistence type
	 *                                       of the given entities.
	 * @throws IOException                   Throws if an entity can not be
	 *                                       persisted.
	 * @since 1.8
	 */
	public <T extends Entity> int persist(Path repository, boolean isAppend, Collection<T> entities)
			throws NullPointerException, UnsupportedOperationException, IllegalArgumentException, IOException {
		if (repository == null)
			repository = this.repository;

		if (repository == null)
			throw new NullPointerException("PersistenceManager: no repository is defined.");

		StringBuffer buffer = new StringBuffer();
		int number = 0;
		if (entities != null)
			for (Entity entity : entities)
				if (entity != null)
					try {
						Type type = Type.getType(entity.getClass());
						if (type == null)
							throw new UnsupportedOperationException(
									"PersistenceManager: no persistence type is defined for the entity class "
											+ entities.getClass() + ".");
						else if (!types.contains(type))
							throw new IllegalArgumentException(
									"PersistenceManager: the persistence manager doesn't support the type "
											+ type.name() + ".");

						buffer.append(
								type.name() + "\t" + objectMapper.writeValueAsString(entity) + System.lineSeparator());

						number++;
					} catch (JsonProcessingException e) {
						throw new IOException("PersistenceManager: troubles processing (parsing, generating) JSON - "
								+ e.getMessage() + ".");
					}

		if (number > 0 || !isAppend)
			try {
				Files.write(repository, buffer.toString().getBytes(), StandardOpenOption.CREATE,
						StandardOpenOption.WRITE,
						isAppend ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
			} catch (Exception e) {
				throw new IOException("PersistenceManager: could not persist entities to repository '" + repository
						+ "' - " + e.getMessage() + ".");
			}

		return number;
	}

	/**
	 * Returns the persisted entity from default repository. If the repository
	 * contains more than one entity, the first one is returned.
	 * 
	 * @return The entity. Null if no entity is available.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public Entity getEntity() throws NullPointerException, IOException {
		return getEntity(null, null);
	}

	/**
	 * Returns the persisted entities from default repository.
	 * 
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public List<Entity> getEntities() throws NullPointerException, IOException {
		return getEntities(null, null, 0, null);
	}

	/**
	 * Returns the persisted entities from default repository.
	 * 
	 * @param comparator The comparison function to sort the entities. Null if
	 *                   returns the repository read order.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public List<Entity> getEntities(Comparator<Entity> comparator) throws NullPointerException, IOException {
		return getEntities(null, comparator);
	}

	/**
	 * Returns the persisted entity from default repository. If the repository
	 * contains more than one entity, the first one is returned.
	 * 
	 * @param message The functional interfaces to account for warning messages. If
	 *                null, ignore warning messages.
	 * @return The entity. Null if no entity is available.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public Entity getEntity(Message message) throws NullPointerException, IOException {
		return getEntity(null, message);
	}

	/**
	 * Returns the persisted entities from default repository.
	 * 
	 * @param message    The functional interfaces to account for warning messages.
	 *                   If null, ignore warning messages.
	 * @param comparator The comparison function to sort the entities. Null if
	 *                   returns the repository read order.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public List<Entity> getEntities(Message message, Comparator<Entity> comparator)
			throws NullPointerException, IOException {
		return getEntities(null, message, 0, comparator);
	}

	/**
	 * Returns the persisted entity. If the repository contains more than one
	 * entity, the first one is returned.
	 * 
	 * @param repository The repository. If null, the default repository is used.
	 * @param message    The functional interfaces to account for warning messages.
	 *                   If null, ignore warning messages.
	 * @return The entity. Null if no entity is available.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public Entity getEntity(Path repository, Message message) throws NullPointerException, IOException {
		List<Entity> entries = getEntities(repository, message, 1, null);

		return entries.isEmpty() ? null : entries.get(0);
	}

	/**
	 * Returns the persisted entities.
	 * 
	 * @param repository The repository. If null, the default repository is used.
	 * @param message    The functional interfaces to account for warning messages.
	 *                   If null, ignore warning messages.
	 * @param comparator The comparison function to sort the entities. Null if
	 *                   returns the repository read order.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public List<Entity> getEntities(Path repository, Message message, Comparator<Entity> comparator)
			throws NullPointerException, IOException {
		return getEntities(repository, message, 0, comparator);
	}

	/**
	 * Returns the persisted entities.
	 * 
	 * @param repository The repository. If null, the default repository is used.
	 * @param message    The functional interfaces to account for warning messages.
	 *                   If null, ignore warning messages.
	 * @param maximum    The maximum number of entities to return. A number less
	 *                   than 1 returns all entities.
	 * @param comparator The comparison function to sort the entities. Null if
	 *                   returns the repository read order.
	 * @param types      The types to filter the entities. If empty, no filter is
	 *                   applied.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public List<Entity> getEntities(Path repository, Message message, int maximum, Comparator<Entity> comparator,
			Type... types) throws NullPointerException, IOException {
		Set<Type> filter = new HashSet<Type>();
		for (Type type : types)
			if (type != null)
				filter.add(type);

		return getEntities(repository, message, maximum, comparator,
				(number, type, entity) -> filter.isEmpty() || filter.contains(type));
	}

	/**
	 * Returns the persisted entities.
	 * 
	 * @param repository The repository. If null, the default repository is used.
	 * @param message    The functional interfaces to account for warning messages.
	 *                   If null, ignore warning messages.
	 * @param maximum    The maximum number of entities to return. A number less
	 *                   than 1 returns all entities.
	 * @param comparator The comparison function to sort the entities. Null if
	 *                   returns the repository read order.
	 * @param filter     The functional interfaces to filter entities. If null, do
	 *                   not filter entities.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public List<Entity> getEntities(Path repository, Message message, int maximum, Comparator<Entity> comparator,
			Filter filter) throws NullPointerException, IOException {
		if (repository == null)
			repository = this.repository;

		if (repository == null)
			throw new NullPointerException("PersistenceManager: no repository is defined.");

		List<Entity> entities = new ArrayList<>();

		if (Files.exists(repository))
			try {
				int number = 0;
				for (String line : Files.readAllLines(repository)) {
					number++;
					line = line.trim();

					// Ignore empty lines and comments, this means, lines starting with #
					if (line.isEmpty() || line.startsWith("#"))
						continue;

					String[] split = line.split("\t", 2);
					if (split.length == 2)
						try {
							Type type = Type.valueOf(split[0]);

							if (types.contains(type))
								try {
									Entity entity = objectMapper.readValue(split[1], type.getTypeClass());

									// Filter required records
									if (filter == null || filter.isThrough(entities.size(), type, entity))
										entities.add(entity);
								} catch (Exception e) {
									if (message != null)
										message.warn(number + ": could not parse line from repository '" + repository
												+ "' (type " + split[0] + ") - " + e.getMessage() + ".");
								}
							else if (message != null)
								message.warn(number + ": the persistence manager doesn't supports the entity type "
										+ type.name() + ".");

						} catch (Exception e) {
							if (message != null)
								message.warn(number + ": unknown entity type '" + split[0] + "' from repository '"
										+ repository + "'.");
						}
					else if (message != null)
						message.warn(number + ": could not parse line from repository '" + repository + "'.");

					if (maximum > 0 && entities.size() >= maximum)
						break;
				}

			} catch (IOException e) {
				throw new IOException(
						"PersistenceManager: could not read repository '" + repository + "' - " + e.getMessage() + ".");
			}

		if (comparator != null)
			Collections.sort(entities, comparator);

		return entities;
	}

	/**
	 * Returns the persisted entity from default repository.
	 * 
	 * @param <T>   The entity class.
	 * @param clazz The entity class.
	 * @return The entity.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public <T extends Entity> T getEntity(Class<T> clazz) throws NullPointerException, IOException {
		return getEntity(clazz, null, null);
	}

	/**
	 * Returns the persisted entities from default repository.
	 * 
	 * @param <T>   The entities class.
	 * @param clazz The entities class.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public <T extends Entity> List<T> getEntities(Class<T> clazz) throws NullPointerException, IOException {
		return getEntities(clazz, null);
	}

	/**
	 * Returns the persisted entity of given class. If the repository contains more
	 * than one entity, the first one is returned.
	 * 
	 * @param <T>        The entity class.
	 * @param clazz      The entity class.
	 * @param repository The repository. If null, the default repository is used.
	 * @param message    The functional interfaces to account for warning messages.
	 *                   If null, ignore warning messages.
	 * @return The entity. Null if no entity is available.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public <T extends Entity> T getEntity(Class<T> clazz, Path repository, Message message)
			throws NullPointerException, IOException {
		List<T> entries = getEntities(clazz, repository, message, 1, null, null);

		return entries.isEmpty() ? null : entries.get(0);
	}

	/**
	 * Returns the persisted entities of given class from default repository.
	 * 
	 * @param <T>     The entities class.
	 * @param clazz   The entities class.
	 * @param message The functional interfaces to account for warning messages. If
	 *                null, ignore warning messages.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public <T extends Entity> List<T> getEntities(Class<T> clazz, Message message)
			throws NullPointerException, IOException {

		return getEntities(clazz, message, null);
	}

	/**
	 * Returns the persisted entities of given class from default repository.
	 * 
	 * @param <T>        The entities class.
	 * @param clazz      The entities class.
	 * @param message    The functional interfaces to account for warning messages.
	 *                   If null, ignore warning messages.
	 * @param comparator The comparison function to sort the entities. Null if
	 *                   returns the repository read order.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	public <T extends Entity> List<T> getEntities(Class<T> clazz, Message message, Comparator<Entity> comparator)
			throws NullPointerException, IOException {

		return getEntities(clazz, null, message, 0, comparator, null);
	}

	/**
	 * Returns the persisted entities of given class.
	 * 
	 * @param <T>        The entities class.
	 * @param clazz      The entities class.
	 * @param repository The repository. If null, the default repository is used.
	 * @param message    The functional interfaces to account for warning messages.
	 *                   If null, ignore warning messages.
	 * @param maximum    The maximum number of entities to return. A number less
	 *                   than 1 returns all entities.
	 * @param comparator The comparison function to sort the entities. Null if
	 *                   returns the repository read order.
	 * @param filter     The functional interfaces to filter entities. If null, do
	 *                   not filter entities.
	 * @return The entities.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be read.
	 * @since 1.8
	 */
	@SuppressWarnings("unchecked")
	public <T extends Entity> List<T> getEntities(Class<T> clazz, Path repository, Message message, int maximum,
			Comparator<Entity> comparator, Filter filter) throws NullPointerException, IOException {

		List<T> entities = new ArrayList<>();
		for (Entity entity : getEntities(repository, message, maximum, comparator, filter))
			try {
				entities.add((T) entity);
			} catch (ClassCastException e) {
				if (message != null)
					message.warn("Could not cast the entity - " + e.getMessage() + ".");
			}

		return entities;
	}

	/**
	 * Zips the default repository and writes it to the output stream.
	 * 
	 * @param outputStream The output stream for writing the zipped repository.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be zipped.
	 * @since 1.8
	 */
	public void zip(OutputStream outputStream) throws NullPointerException, IOException {
		zip(null, outputStream);
	}

	/**
	 * Zips the repository and writes it to the output stream.
	 * 
	 * @param repository   The repository. If null, the default repository is used.
	 * @param outputStream The output stream for writing the zipped repository.
	 * @throws NullPointerException Throws if the no repository is defined.
	 * @throws IOException          Throws if the repository can not be zipped.
	 * @since 1.8
	 */
	public void zip(Path repository, OutputStream outputStream) throws NullPointerException, IOException {
		if (repository == null)
			repository = this.repository;

		if (repository == null)
			throw new NullPointerException("PersistenceManager: no repository is defined.");

		try (ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);) {
			ZipEntry zipEntry = new ZipEntry(repository.getFileName().toString());
			zipOutputStream.putNextEntry(zipEntry);

			if (Files.exists(repository))
				Files.copy(repository, zipOutputStream);

			zipOutputStream.closeEntry();
			outputStream.flush();
		}
	}

	/**
	 * Defines functional interfaces to account for warning messages.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	@FunctionalInterface
	public interface Message {
		/**
		 * Account for warning messages.
		 * 
		 * @param message The content.
		 * @since 1.8
		 */
		public void warn(String message);
	}

	/**
	 * Defines functional interfaces to filter entities.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	@FunctionalInterface
	public interface Filter {
		/**
		 * Returns true if the entity can pass the filter.
		 * 
		 * @param number The number of persisted entities.
		 * @param type   The persistence type.
		 * @param entity The entity.
		 * @return True if the entity can pass the filter.
		 * @since 1.8
		 */
		public boolean isThrough(int number, Type type, Entity entity);
	}

}
