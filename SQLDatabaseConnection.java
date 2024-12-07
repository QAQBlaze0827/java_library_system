import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    public static void main(String[] args) {
        String connectionUrl = 
                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
                + "database=AdventureWorks;"
                + "user=yourusername@yourserver;"
                + "password=" + System.getenv("DB_PASSWORD") + ";" // 改用環境變數
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            System.out.println("成功連接到 SQL Server!");

            // 執行查詢的示例
            String query = "SELECT TOP 10 * FROM SalesLT.Product";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("產品名稱: " + resultSet.getString("Name"));
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ 連接失敗，請檢查連線參數或網路問題");
            e.printStackTrace();
        }
    }
}
