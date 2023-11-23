/**
 * File:     Folio.java
 * Package:  de.uniwuerzburg.zpd.ocr4all.application.persistence.project
 * 
 * Author:   Herbert Baier (herbert.baier@uni-wuerzburg.de)
 * Date:     07.04.2021
 */
package de.uniwuerzburg.zpd.ocr4all.application.persistence.folio;

import java.util.Date;
import java.util.Set;

import de.uniwuerzburg.zpd.ocr4all.application.persistence.Keyword;
import de.uniwuerzburg.zpd.ocr4all.application.persistence.util.ImageFormat;

/**
 * Defines folios for projects.
 *
 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
 * @version 1.0
 * @since 1.8
 */
public class Folio extends Keyword {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Define PAGE XML types.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public enum PageXMLType {
		frontCover("front-cover"), backCover("back-cover"), title, tableOfContents("table-of-contents"), index, content,
		blank, other;

		/**
		 * The label.
		 */
		private final String label;

		/**
		 * Creates a PAGE XML type.
		 * 
		 * @since 1.8
		 */
		private PageXMLType() {
			this.label = this.name();
		}

		/**
		 * Creates a PAGE XML type.
		 * 
		 * @param label The label.
		 * @since 1.8
		 */
		private PageXMLType(String label) {
			this.label = label;
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

	}

	/**
	 * The identifier.
	 */
	private String id = null;

	/**
	 * The name without extension.
	 */
	private String name = null;

	/**
	 * The format.
	 */
	private ImageFormat format = null;

	/**
	 * The size.
	 */
	private Size size = null;

	/**
	 * The sizes for the folios derivatives quality images.
	 */
	private Derivatives derivatives = null;

	/**
	 * The PAGE XML type.
	 */
	private PageXMLType pageXMLType = null;

	/**
	 * Default constructor for a folio.
	 * 
	 * @since 1.8
	 */
	public Folio() {
		super();
	}

	/**
	 * Creates a folio.
	 * 
	 * @param date        The date.
	 * @param user        The user.
	 * @param id          The id.
	 * @param name        The name without extension.
	 * @param format      The format.
	 * @param size        The size.
	 * @param derivatives The sizes for the folios derivatives quality images.
	 * @since 1.8
	 */
	public Folio(Date date, String user, String id, String name, ImageFormat format, Size size,
			Derivatives derivatives) {
		this(date, user, null, id, name, format, size, derivatives);
	}

	/**
	 * Creates a folio.
	 * 
	 * @param date        The date.
	 * @param user        The user.
	 * @param keywords    The keywords.
	 * @param id          The id.
	 * @param name        The name without extension.
	 * @param format      The format.
	 * @param size        The size.
	 * @param derivatives The sizes for the folios derivatives quality images.
	 * @since 1.8
	 */
	public Folio(Date date, String user, Set<String> keywords, String id, String name, ImageFormat format, Size size,
			Derivatives derivatives) {
		super(date, user, keywords);

		setId(id);
		setName(name);
		setFormat(format);
		setSize(size);
		setDerivatives(derivatives);
	}

	/**
	 * Returns the identifier.
	 *
	 * @return The identifier.
	 * @since 1.8
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the identifier.
	 *
	 * @param id The identifier to set.
	 * @since 1.8
	 */
	public void setId(String id) {
		this.id = id;
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
	 * Returns the format.
	 *
	 * @return The format.
	 * @since 1.8
	 */
	public ImageFormat getFormat() {
		return format;
	}

	/**
	 * Set the format.
	 *
	 * @param format The format to set.
	 * @since 1.8
	 */
	public void setFormat(ImageFormat format) {
		this.format = format;
	}

	/**
	 * Returns the size.
	 *
	 * @return The size.
	 * @since 1.8
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * Set the size.
	 *
	 * @param size The size to set.
	 * @since 1.8
	 */
	public void setSize(Size size) {
		this.size = size;
	}

	/**
	 * Returns the sizes for the folios derivatives quality images.
	 *
	 * @return The sizes for the folios derivatives quality images.
	 * @since 1.8
	 */
	public Derivatives getDerivatives() {
		return derivatives;
	}

	/**
	 * Set the sizes for the folios derivatives quality images.
	 *
	 * @param derivatives The derivatives to set.
	 * @since 1.8
	 */
	public void setDerivatives(Derivatives derivatives) {
		this.derivatives = derivatives;
	}

	/**
	 * Returns the PAGE XML type.
	 *
	 * @return The PAGE XML type.
	 * @since 1.8
	 */
	public PageXMLType getPageXMLType() {
		return pageXMLType;
	}

	/**
	 * Set the PAGE XML type.
	 *
	 * @param pageXMLType The PAGE XML type to set.
	 * @since 1.8
	 */
	public void setPageXMLType(PageXMLType pageXMLType) {
		this.pageXMLType = pageXMLType;
	}

	/**
	 * Defines folio sizes.
	 *
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public static class Size {
		/**
		 * The width.
		 */
		private int width = 0;

		/**
		 * The height.
		 */
		private int height = 0;

		/**
		 * Default constructor for a folio size.
		 * 
		 * @since 1.8
		 */
		public Size() {
			super();
		}

		/**
		 * Creates a folio size.
		 * 
		 * @param width  The width.
		 * @param height The height.
		 * @since 1.8
		 */
		public Size(int width, int height) {
			super();
			this.width = width;
			this.height = height;
		}

		/**
		 * Returns the width.
		 *
		 * @return The width.
		 * @since 1.8
		 */
		public int getWidth() {
			return width;
		}

		/**
		 * Set the width.
		 *
		 * @param width The width to set.
		 * @since 1.8
		 */
		public void setWidth(int width) {
			this.width = width;
		}

		/**
		 * Returns the height.
		 *
		 * @return The height.
		 * @since 1.8
		 */
		public int getHeight() {
			return height;
		}

		/**
		 * Set the height.
		 *
		 * @param height The height to set.
		 * @since 1.8
		 */
		public void setHeight(int height) {
			this.height = height;
		}
	}

	/**
	 * Defines sizes for the folios derivatives quality images.
	 *
	 * 
	 * @author <a href="mailto:herbert.baier@uni-wuerzburg.de">Herbert Baier</a>
	 * @version 1.0
	 * @since 1.8
	 */
	public static class Derivatives {
		/**
		 * The size for folios derivatives quality thumbnail.
		 */
		private Size thumbnail;

		/**
		 * The size for folios derivatives quality detail.
		 */
		private Size detail;

		/**
		 * The size for folios derivatives quality best.
		 */
		private Size best;

		/**
		 * Default constructor for sizes of the folios derivatives quality images.
		 * 
		 * @since 1.8
		 */
		public Derivatives() {
			super();
		}

		/**
		 * Creates sizes of the folios derivatives quality images
		 * 
		 * @param thumbnail The size for folios derivatives quality thumbnail.
		 * @param detail    The size for folios derivatives quality detail.
		 * @param best      The size for folios derivatives quality best.
		 * @since 1.8
		 */
		public Derivatives(Size thumbnail, Size detail, Size best) {
			super();

			this.thumbnail = thumbnail;
			this.detail = detail;
			this.best = best;
		}

		/**
		 * Returns the size for folios derivatives quality thumbnail.
		 *
		 * @return The size for folios derivatives quality thumbnail.
		 * @since 1.8
		 */
		public Size getThumbnail() {
			return thumbnail;
		}

		/**
		 * Set the size for folios derivatives quality thumbnail.
		 *
		 * @param size The size to set.
		 * @since 1.8
		 */
		public void setThumbnail(Size size) {
			thumbnail = size;
		}

		/**
		 * Returns the size for folios derivatives quality detail.
		 *
		 * @return The size for folios derivatives quality detail.
		 * @since 1.8
		 */
		public Size getDetail() {
			return detail;
		}

		/**
		 * Set the size for folios derivatives quality detail.
		 *
		 * @param size The size to set.
		 * @since 1.8
		 */
		public void setDetail(Size size) {
			detail = size;
		}

		/**
		 * Returns the size for folios derivatives quality best.
		 *
		 * @return The size for folios derivatives quality best.
		 * @since 1.8
		 */
		public Size getBest() {
			return best;
		}

		/**
		 * Set the size for folios derivatives quality best.
		 *
		 * @param size The size to set.
		 * @since 1.8
		 */
		public void setBest(Size size) {
			this.best = size;
		}

	}
}
