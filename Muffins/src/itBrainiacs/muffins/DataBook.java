package itBrainiacs.muffins;

import android.os.Parcel;
import android.os.Parcelable;

/** Entity class for creating a DataBook object */
public class DataBook implements Parcelable {

	private String title;
	private String author;
	private String publisher;
	private String language;
	private String isbn;
	private String edition;
	private String publYear;
	private String course;
	private String period;
	private String bookType;
	private Boolean sold;
	private String price;
	private String expires;
	private String saleID;
	private String comment;
	
	private String name;
	private String email;
	private String phone;
	private String password;

	/**
	 * Instantiates a new data book.
	 */
	public DataBook() {
	}

	/**
	 * Gets the isbn.
	 * 
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Sets the isbn.
	 * 
	 * @param isbn
	 *            the new isbn
	 */
	public void setIsbn(String isbn) {
		if (!isbn.equals(""))
			this.isbn = isbn;
	}

	/**
	 * Gets the edition.
	 * 
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the edition.
	 * 
	 * @param edition
	 *            the new edition
	 */
	public void setEdition(String edition) {
		if (!edition.equals(""))
			this.edition = edition;
	}

	/**
	 * Gets the publ year.
	 * 
	 * @return the publ year
	 */
	public String getPublYear() {
		return publYear;
	}

	/**
	 * Sets the publ year.
	 * 
	 * @param publYear
	 *            the new publ year
	 */
	public void setPublYear(String publYear) {
		if (!publYear.equals(""))
			this.publYear = publYear;
	}

	/**
	 * Gets the course.
	 * 
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * Sets the course.
	 * 
	 * @param course
	 *            the new course
	 */
	public void setCourse(String course) {
		if (!course.equals(""))
			this.course = course;
	}

	/**
	 * Gets the period.
	 * 
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * Sets the period.
	 * 
	 * @param period
	 *            the new period
	 */
	public void setPeriod(String period) {
		if (!period.equals(""))
			this.period = period;
	}

	/**
	 * Gets the book type.
	 * 
	 * @return the book type
	 */
	public String getBookType() {
		return bookType;
	}

	/**
	 * Sets the book type.
	 * 
	 * @param bookType
	 *            the new book type
	 */
	public void setBookType(String bookType) {
		if (!bookType.equals(""))
			this.bookType = bookType;
	}

	/**
	 * Gets the sold.
	 * 
	 * @return the sold
	 */
	public Boolean getSold() {
		return sold;
	}

	/**
	 * Sets the sold.
	 * 
	 * @param sold
	 *            the new sold
	 */
	public void setSold(Boolean sold) {
		if (!sold.equals(""))
			this.sold = sold;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(String price) {
		if (!price.equals(""))
			this.price = price;
	}

	/**
	 * Gets the expires.
	 * 
	 * @return the expires
	 */
	public String getExpires() {
		return expires;
	}

	/**
	 * Sets the expires.
	 * 
	 * @param expires
	 *            the new expires
	 */
	public void setExpires(String expires) {
		if (!expires.equals(""))
			this.expires = expires;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		if (!name.equals(""))
			this.name = name;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		if (!email.equals(""))
			this.email = email;
	}

	/**
	 * Gets the phone.
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 * 
	 * @param phone
	 *            the new phone
	 */
	public void setPhone(String phone) {
		if (!phone.equals(""))
			this.phone = phone;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		if (!password.equals(""))
			this.password = password;
	}

	/**
	 * Gets the sale id.
	 * 
	 * @return the sale id
	 */
	public String getSaleID() {
		return saleID;
	}

	/**
	 * Sets the sale id.
	 * 
	 * @param saleID
	 *            the new sale id
	 */
	public void setSaleID(String saleID) {
		if (!saleID.equals(""))
			this.saleID = saleID;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		if (!title.equals(""))
			this.title = title;
	}

	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(String author) {
		if (!author.equals(""))
			this.author = author;
	}

	/**
	 * Gets the publisher.
	 * 
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Sets the publisher.
	 * 
	 * @param publisher
	 *            the new publisher
	 */
	public void setPublisher(String publisher) {
		if (!publisher.equals(""))
			this.publisher = publisher;
	}

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * 
	 * @param language
	 *            the new language
	 */
	public void setLanguage(String language) {
		if (!language.equals(""))
			this.language = language;
	}

	/**
	 * Gets the comment.
	 * 
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 * 
	 * @param comment
	 *            the new comment
	 */
	public void setComment(String comment) {
		if (!comment.equals(""))
			this.comment = comment;
	}

	/**
	 * Used by the Parcelable-interface to identify which type of object to create from the parcel
	 * @see android.os.Parcelable#describeContents()
	 */
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Creates a parcel of the DataBook to allow it being sent with intents between activities
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 * 
	 * @param bookParcel name of the created parcel
	 * @param flags 
	 */
	public void writeToParcel(Parcel bookParcel, int flags) {
		bookParcel.writeString(price);
		
		if (isbn == null)
			isbn = "";
		bookParcel.writeString(isbn);
		
		if (author == null)
			author = "";
		bookParcel.writeString(author);
		
		if (title == null)
			title = "";
		bookParcel.writeString(title);
		
		if (edition == null)
			edition = "";
		bookParcel.writeString(edition);
		
		if (course == null)
			course = "";
		bookParcel.writeString(course);
		
		if (comment == null)
			comment = "";
		bookParcel.writeString(comment);
		
		if (email == null)
			email = "";
		bookParcel.writeString(email);
	
		if (name == null)
			name = "";
		bookParcel.writeString(name);
		
		if (phone == null)
			phone = "";
		bookParcel.writeString(phone);
	}

	/**
	 * Creates a new DataBook from an existing parcel
	 * 
	 * @param source Incoming parcel to be unpacked
	 */
	public DataBook(Parcel source) {
		price = source.readString();
		
		isbn = source.readString();
		if (isbn.length() == 0)
			isbn = null;
		
		author = source.readString();
		if (author.length() == 0)
			author = null;
		
		title = source.readString();
		if (title.length() == 0)
			title = null;
		
		edition = source.readString();
		if (edition.length() == 0)
			edition = null;
		
		course = source.readString();
		if (course.length() == 0)
			course = null;
		
		comment = source.readString();
		if (comment.length() == 0)
			comment = null;
		
		email = source.readString();
		if (email.length() == 0)
			email = null;
		
		name = source.readString();
		if (name.length() == 0)
			name = null;
		
		phone = source.readString();
		if (phone.length() == 0)
			phone = null;
	}

	/**
	 * Methods used by the Parcelable-interface
	 * @see android.os.Parcelable
	 */
	public static final Parcelable.Creator<DataBook> CREATOR = new Parcelable.Creator<DataBook>() {

		public DataBook createFromParcel(Parcel in) {
			return new DataBook(in);
		}

		public DataBook[] newArray(int size) {
			return new DataBook[size];
		}
	};

}
