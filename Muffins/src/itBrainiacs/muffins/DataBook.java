package itBrainiacs.muffins;

import android.os.Parcel;
import android.os.Parcelable;

public class DataBook implements Parcelable {

	private String title;
	private String author;
	private String publisher;
	private String date; 
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
	private String email;
	private String phone;
	private String password;
	private String saleID;
	private String comment;
	
	public DataBook(){
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (!isbn.equals(""))
			this.isbn = isbn;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		if (!edition.equals(""))
			this.edition = edition;
	}

	public String getPublYear() {
		return publYear;
	}

	public void setPublYear(String publYear) {
		if(!publYear.equals(""))
			this.publYear = publYear;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		if(!course.equals(""))
			this.course = course;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		if(!period.equals(""))
			this.period = period;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		if(!bookType.equals(""))
			this.bookType = bookType;
	}

	public Boolean getSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		if(!sold.equals(""))
			this.sold = sold;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		if(!price.equals(""))
			this.price = price;
	}

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		if(!expires.equals(""))
			this.expires = expires;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(!email.equals(""))
			this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if(!phone.equals(""))
			this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(!password.equals(""))
			this.password = password;
	}

	public String getSaleID() {
		return saleID;
	}

	public void setSaleID(String saleID) {
		if(!saleID.equals(""))
			this.saleID = saleID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(!title.equals(""))
			this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(!author.equals(""))
			this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		if(!publisher.equals(""))
			this.publisher = publisher;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		if(!language.equals(""))
			this.language = language;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		if(!comment.equals(""))
			this.comment = comment;
	}
	
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void writeToParcel(Parcel bookParcel, int flags) {
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
	}
	
	
	public DataBook(Parcel source){
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
	}
    
	public static final Parcelable.Creator<DataBook> CREATOR
    	= new Parcelable.Creator<DataBook>() {
	
		public DataBook createFromParcel(Parcel in) {
			return new DataBook(in);
		}

		public DataBook[] newArray(int size) {
			return new DataBook[size];
		}
	};

}

   
