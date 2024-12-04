import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class Mainframe extends JFrame {
    private JPanel panel = new JPanel();
    private Container cp;

    public Mainframe() {
        init();
    }

    private void init() {
        // 視窗基本設定
        this.setTitle("Login Library System");
        this.setSize(600, 350);
        this.setLocation(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 處理版面
        cp = this.getContentPane();
        cp.setLayout(null);
        panel.setBounds(0, 0, 400, 400);
        cp.add(panel);
        panel.setLayout(null);

        // 添加元件
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 300, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 300, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Admin 帳號驗證
        Admin admin = new Admin();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword()); // 將 char[] 轉為 String
                if (admin.getAdminName().equals(username) && admin.getAdminPassword().equals(password)) {
                    System.out.println("Login Success");
                } else {
                    System.out.println("Login Fail");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
}

class People {
    private String username;
    private String password;
}

class Admin extends People {
    private String adminName;
    private String adminPassword;

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
