import java.sql.*;

public class University {

    private static Connection conn;
    private static Statement statement;
    private static ResultSet rs;

    public static void main(String[] args) {
        getQuantity("ФТИК");
        getQuantity("ФИРТ");
    }

    private static void getQuantity(String facName) {
        start();
        try {
            String sqlQuery ="SELECT count(s.id) AS Quantity FROM fac_tbl AS f JOIN students_tbl AS s ON s.fac_id = f.id WHERE f.name_fld = \"" + facName + "\";";
            statement = conn.createStatement();
            rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                System.out.println("Количество студентов на факультете " + facName + " равно " + rs.getInt("Quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stop();
    }

    public static void start() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?useSSL=false", "dbuser", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

