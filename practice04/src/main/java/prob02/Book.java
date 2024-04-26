package prob02;

public class Book {

    int bookNo;
    String title;
    String author;
    int stateCode;

    public Book(int bookNo, String title, String author) {
        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
        this.stateCode = 1;
    }

    public int getStateCode() {
        return stateCode;
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
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

    public void rent() {
        this.stateCode = 0;
    }

    public void print() {

    }
}
