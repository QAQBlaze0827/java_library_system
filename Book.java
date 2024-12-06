public class Book {

    private String bookName;
    private int bookID;
    private boolean isBorrowed;
    
    // public Book() {
    //     this.bookName ;
    //     this.bookID;
    //     this.isBorrowed = false;
    // }
    public void addBook(String bookName, int bookID) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.isBorrowed = false;
    }
    public String getBookName(){
        return bookName;
    }
    public int getBookID(){
        return bookID;
    }
    public boolean getIsBorrowed(){
        return isBorrowed;
    }
}
