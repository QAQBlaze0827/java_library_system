import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainSystemui extends JFrame {
    private Container cp;
    private final JPanel userPanel = new JPanel();

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

        userPanel.setBounds(0, 0, 400, 100); // 設置面板大小
        userPanel.setBackground(Color.RED); 
        cp.add(userPanel); // 將面板添加到容器

        JLabel label = new JLabel("Welcome to Library System");
        label.setBounds(0, 0, 200, 30); // 設置標籤大小和位置
        userPanel.setLayout(null); // 記得設置面板的佈局
        userPanel.add(label); // 將標籤添加到面板

        this.setResizable(true); // 確保視窗大小可以調整
    }

    public static void main(String[] args) {
        new MainSystemui().setVisible(true);
    }
}
