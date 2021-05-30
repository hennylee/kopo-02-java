package vo;

import java.io.Serializable;
import java.util.List;

public class BookVO implements Serializable  {
	private int bookBarcode;
	private String bookName;
	private String bookAuthor; 
	private String bookPublisher;
	private String bookCategory; 
	/**
	 * 대출중 : true , 대출가능 : false
	 */
	private boolean isReserved;
	
	public void setBookBarcode(int bookBarcode) {
		this.bookBarcode = bookBarcode;
	}
	public int getBookBarcode() {
		return bookBarcode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	/**
	 * 대출중 : true , 대출가능 : false
	 */
	public boolean isReserved() {
		return isReserved;
	}

	/**
	 * 대출중 : true , 대출가능 : false
	 */
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	@Override
    public String toString() {
        return bookBarcode + "\t" + bookName + "\t" + bookAuthor + "\t" + bookPublisher + "\t" + bookCategory + "\t" + isReserved + "\t";
    }
	
	
	
}
