/**
 * File:     PersistenceTools.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.util
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     26.03.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.util;

import java.util.Comparator;
import java.util.Date;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Entity;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.Tracking;

/**
 * Defines persistence tools.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class PersistenceTools {
	/**
	 * Returns a comparison function, which imposes a total ordering on some
	 * collection of tracking entities. The entities that cannot be sorted are
	 * placed at the end.
	 * 
	 * @param isAscending True if sorting is in ascending order. Otherwise sorting
	 *                    is in descending order.
	 * @return
	 * @since 1.8
	 */
	public static Comparator<Entity> getTrackingDateComparator(final boolean isAscending) {
		return (Entity o1, Entity o2) -> {
			if (o1 == null || !(o1 instanceof Tracking))
				return 1;
			else if (o2 == null || !(o2 instanceof Tracking))
				return -1;
			else {
				Date date1 = ((Tracking) o1).getDate();
				Date date2 = ((Tracking) o2).getDate();

				if (date1 == null)
					return 1;
				else if (date2 == null)
					return -1;
				else
					return isAscending ? date1.compareTo(date2) : date2.compareTo(date1);
			}
		};
	}
}
