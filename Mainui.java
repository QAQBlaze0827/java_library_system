public class Mainui {
    public static void main(String[] args) {
        Loginui mainframe = new Loginui();
        mainframe.setVisible(true);
        Library library = new Library();

        // 新增書籍
        library.addBook("Harry Potter", 1);
        library.addBook("The Hobbit", 2);

        // 顯示書籍
        library.displayBooks();
        System.out.println("-----");
        // 借書
        library.borrowBook(1);
        System.out.println("-----");
        //展示書籍
        library.displayBooks();

        // 嘗試再次借書
        library.borrowBook(1); // 這次會失敗

        // 還書
        library.returnBook(1); 

        // 刪除書籍
        library.deleteBook(2);

        // 顯示書籍
        library.displayBooks();
    }
}

