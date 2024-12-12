public class Book {

    private String bookName;
    private int bookID;
    private boolean isBorrowed;

    public void addBook(String bookName, int bookID) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.isBorrowed = false;
    }
    public void deleteBook(int bookid){
        if (bookid == this.bookID){
            this.bookName = null;
            this.bookID = 0;
            this.isBorrowed = false;
        }
        else{
            System.out.println("Book ID not found");
        }
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
    public void borrowBook(){
        this.isBorrowed = true;
    }
}
