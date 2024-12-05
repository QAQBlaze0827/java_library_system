import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class Loginui extends JFrame {
    private final JPanel panel = new JPanel();
    private Container cp;

    public Loginui() {
        init();
    }

    private void init() {
        // 視窗基本設定
        this.setTitle("Login Library System");
        this.setSize(400, 200);
        this.setLocation(700, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 處理版面
        cp = this.getContentPane();
        cp.setLayout(null);
        panel.setBounds(0, 0, 400, 400);
        cp.add(panel);
        panel.setLayout(null);

        // 添加元件
        //setBounds 設定元件位置跟 大小
        JLabel userLabel = new JLabel("User:"); 
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 200, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 200, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Admin 帳號驗證
        Admin admin = new Admin();

        loginButton.addActionListener((ActionEvent e) -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword()); // 將 char[] 轉為 String
            if (admin.getAdminName().equals(username) && admin.getAdminPassword().equals(password)) {
                this.setVisible(false);
                MainSystemui mainSystemui = new MainSystemui();
                mainSystemui.setVisible(true);
                System.out.println("Login Success");
            } else {
                System.out.println("Login Fail");
                userText.setText("");
                passwordText.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new Loginui().setVisible(true);
    }
}
class Admin{
    private final String adminName;
    private final String adminPassword;

    public Admin() {
        this.adminName = "admin";
        this.adminPassword = "password";
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
