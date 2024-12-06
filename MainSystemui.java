import java.awt.*;
import javax.swing.*;


public class MainSystemui extends JFrame {
    private Container cp;
    private CardLayout cardLayout;
    private final JPanel userPanel= new JPanel();
    private final JPanel functionPanel = new JPanel();
    private JPanel contentPanel;

    public MainSystemui() {
        init();
    }

    private void init() {
        //初始化視窗
        this.setTitle("Library System");
        this.setSize(1000, 750); // 設定初始大小
        this.setLocation(500, 200); // 設定視窗初始位置
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = this.getContentPane(); 
        cp.setLayout(null); 

        //使用者 panel
        //用來做歡迎小介面的
        userPanel.setBounds(0, 0, 200, 50);
        userPanel.setBackground(new Color(161,196,253)); 
        cp.add(userPanel); 
        Admin admin = new Admin();
        JLabel label = new JLabel("Welcome " + admin.getAdminName());
        label.setBounds(0, 0, 200, 30); 
        userPanel.setLayout(null);
        userPanel.add(label);

        //-----------------功能 panel
        //這邊應該可以在優化

        functionPanel.setBounds(0, 50, 200, 700);
        functionPanel.setBackground(Color.lightGray);
        functionPanel.setLayout(null);
        cp.add(functionPanel); 

        //功能panel 中的新增書籍(僅管理員可使用)
        JButton addBookButton = new JButton("Add Book"); 
        addBookButton.setBounds(0, 0, 200, 50);
        addBookButton.setAlignmentX(LEFT_ALIGNMENT); 
        functionPanel.add(addBookButton); 
        //功能panel 中的刪除書籍(僅管理員可使用)
        JButton deleteBookButton = new JButton("Delete Book");
        deleteBookButton.setBounds(0, 50, 200, 50);
        deleteBookButton.setAlignmentX(LEFT_ALIGNMENT);
        functionPanel.add(deleteBookButton); 
        //功能panel 中的查詢書籍
        JButton searchBookButton = new JButton("Search Book");
        searchBookButton.setBounds(0, 100, 200, 50); 
        searchBookButton.setAlignmentX(LEFT_ALIGNMENT);
        functionPanel.add(searchBookButton);
        //功能panel 中的借閱書籍(僅讀者可使用)
        JButton borrowBookButton = new JButton("Borrow Book"); 
        borrowBookButton.setBounds(0, 150, 200, 50); 
        borrowBookButton.setAlignmentX(LEFT_ALIGNMENT); 
        functionPanel.add(borrowBookButton); 
        //功能panel 中的還書(僅讀者可使用)
        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.setBounds(0, 200, 200, 50);
        returnBookButton.setAlignmentX(LEFT_ALIGNMENT);
        functionPanel.add(returnBookButton); 
        //功能panel 中的讀者借書紀錄(僅讀者可使用)
        JButton borrowRecordButton = new JButton("Borrow Record"); 
        borrowRecordButton.setBounds(0, 250, 200, 50);
        borrowRecordButton.setAlignmentX(LEFT_ALIGNMENT); 
        functionPanel.add(borrowRecordButton);
        //-----------------功能 panel end

        //------------------右邊的panel
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBounds(200, 0, 800, 750);
        cp.add(contentPanel);

        //新增書籍的panel
        JPanel addBookPanel = new JPanel();
        addBookPanel.setBounds(200, 0, 800, 750);
        addBookPanel.setBackground(Color.white);
        cp.add(addBookPanel);
        addBookPanel.setLayout(null);
        addBookPanel.setVisible(true); // 一開始不顯示
        contentPanel.add(addBookPanel, "AddBook");
        //書籍的panel中的元件
        JLabel title = new JLabel("Add Book System");
        title.setBounds(10, 10, 200, 25);
        title.setAlignmentX(CENTER_ALIGNMENT);
        addBookPanel.add(title);
        JLabel bookNameLabel = new JLabel("Book Name:");
        bookNameLabel.setBounds(10, 50, 80, 25);
        addBookPanel.add(bookNameLabel);
        JTextField bookNameText = new JTextField(20); 
        bookNameText.setBounds(100, 50, 200, 25); 
        addBookPanel.add(bookNameText); 

        JLabel bookID = new JLabel("Book ID"); 
        bookID.setBounds(10, 80, 80, 25); 
        addBookPanel.add(bookID);
        JTextField bookIDText = new JTextField(20);
        bookIDText.setBounds(100, 80, 200, 25); 
        addBookPanel.add(bookIDText);

        JButton addBook = new JButton("Add Book"); 
        addBook.setBounds(10, 110, 80, 25); 
        addBook.setAlignmentX(LEFT_ALIGNMENT); 
        addBookPanel.add(addBook); 
        //書籍的panel中的元件 end

        //刪除書籍的paenl
        JPanel deleteBookPanel = new JPanel();
        deleteBookPanel.setBounds(200, 0, 800, 750);
        deleteBookPanel.setBackground(Color.green);
        cp.add(deleteBookPanel);
        deleteBookPanel.setLayout(null);
        deleteBookPanel.setVisible(true); // 一開始不顯示
        contentPanel.add(deleteBookPanel, "DeleteBook");
        //------------------
        //------------------右邊的panel end

        
        //監控 控制右邊panel 的按鈕
        addBookButton.addActionListener((e) -> cardLayout.show(contentPanel, "AddBook"));
        deleteBookButton.addActionListener((e) -> {cardLayout.show(contentPanel, "DeleteBook");});
        //監控新增的按鈕
        addBook.addActionListener((e) ->{
            // 新增書籍
            int book_ID = Integer.parseInt(bookIDText.getText());
            Book book = new Book();
            book.addBook(bookNameText.getText(), book_ID);
            System.out.println(book.getBookName());
            System.out.println(book.getBookID());
            System.out.println(book.getIsBorrowed());
            System.out.println("Add Book Success");
            bookNameText.setText("");
            bookIDText.setText("");
        });
        //底下這不知道幹嘛的
        this.setResizable(true); // 確保視窗大小可以調整
    }
    public static void main(String[] args) {
        new MainSystemui().setVisible(true);
    }
}
