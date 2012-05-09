package itBrainiacs.muffins;

import android.os.Parcel;
import android.os.Parcelable;

public class DataBook implements Parcelable {

	private String title = "";
	private String author = "";
	private String publisher = "";
	private String date = ""; 
	private String language = "";
	private String isbn = "";
	private String edition = "";
	private String publYear = "";
	private String course = "";
	private String period = "";
	private String booktype = "";
	private Boolean sold = false;
	private String price = "";
	private String expires = "";
	private String email = "";
	private String phone = "";
	private String password = "";
	private String saleId = "";
	
	public DataBook(){
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublYear() {
		return publYear;
	}

	public void setPublYear(String publYear) {
		this.publYear = publYear;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getBooktype() {
		return booktype;
	}

	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}

	public Boolean getSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		this.expires = expires;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
	
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void writeToParcel(Parcel parcBook, int arg1) {
		parcBook.writeString(isbn);
		parcBook.writeString(author);
		parcBook.writeString(title);
		parcBook.writeString(edition);
		parcBook.writeString(course);
	}
	
	
	public DataBook(Parcel source){
        isbn = source.readString();
        author = source.readString();
        title = source.readString();
        edition = source.readString();
        course = source.readString();

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

   
