// Admin.java
public class Admin {
    private final String adminUser;
    private final String adminPassword;
    private final String adminName;

    public Admin() {
        this.adminUser = "admin";
        this.adminPassword = "password";
        this.adminName = "QAQBlaze";
    }

    public String getAdminUser() {
        return adminUser;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }
}
