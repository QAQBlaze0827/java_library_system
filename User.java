import java.util.ArrayList;
import java.util.List;
class User {
    private int uid;
    private String uname;
    private String upassword;
    private List<Book> borrowedBooks;

    // 建構子
    public User(int uid, String uname, String upassword) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.borrowedBooks = new ArrayList<>();
    }
    public int getUid(){
        return uid;
    }
    public String getUname(){
        return uname;
    }
    public String getUpassword(){
        return upassword;
    }
    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }
    // 將 User 轉為 CSV 行
    public String toCsvRow() {
        return uid + "," + uname + "," + upassword;
    }
    //借書功能
    public void borrowBook(Book book){
        if(!book.getIsBorrowed()){ //檢查書本是否已被借出
            this.borrowedBooks.add(book);
            book.borrowBook(); //更新書本狀態
            System.out.println(this.uname+"成功借了"+book.getBookName());
        }else{
            System.out.println(book.getBookName()+"此書已被借走");
        }
    }
    //解析 CSV 文件中的行
    public static User fromCsvRow(String csvRow){
        String[] parts=csvRow.split(",");
        int uid=Integer.parseInt(parts[0]);
        String uname=parts[1];
        String upassword=parts[2];
        return new User(uid, uname, upassword); // 修正後

    }
}