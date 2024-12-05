import java.awt.Color;
import java.awt.Container;
import javax.swing.*;


public class MainSystemui extends JFrame {
    private Container cp;
    private final JPanel userPanel= new JPanel();
    private final JPanel functionPanel = new JPanel();

    public MainSystemui() {
        init();
    }

    private void init() {
        this.setTitle("Library System");
        this.setSize(800, 750); // 設定初始大小
        this.setLocation(500, 200); // 設定視窗初始位置
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 容器和佈局
        cp = this.getContentPane(); 
        cp.setLayout(null); // 使用 null layout，但需要手動設置所有元件大小
        //使用者 panel
        userPanel.setBounds(0, 0, 400, 50); // 設置面板大小
        userPanel.setBackground(Color.RED); 
        cp.add(userPanel); // 將面板添加到容器
        Admin admin = new Admin();
        JLabel label = new JLabel("Welcome " + admin.getAdminName()); // 創建標籤
        label.setBounds(0, 0, 200, 30); // 設置標籤大小和位置
        userPanel.setLayout(null); // 記得設置面板的佈局
        userPanel.add(label); // 將標籤添加到面板
        //功能 panel
        functionPanel.setBounds(0, 50, 400, 700); // 設置面板大小
        functionPanel.setBackground(Color.lightGray);
        functionPanel.setLayout(new BoxLayout(functionPanel, BoxLayout.Y_AXIS)); // 使用 BoxLayout，設置為 Y 軸排列
        cp.add(functionPanel); // 將面板添加到容器
        JButton addBookButton = new JButton("Add Book"); // 創建按鈕
        addBookButton.setBounds(0, 0, 100, 30); // 設置按鈕大小和位置
        addBookButton.setAlignmentX(CENTER_ALIGNMENT); // 設置按鈕置中
        functionPanel.add(addBookButton); // 將按鈕添加到面板

        

        this.setResizable(true); // 確保視窗大小可以調整
    }

    public static void main(String[] args) {
        new MainSystemui().setVisible(true);
    }
}
