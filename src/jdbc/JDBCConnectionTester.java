package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCConnectionTester {
    public void test() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR",
                "password");
                PreparedStatement preparedStatement = connection
                        .prepareStatement("Select * from COUNTRIES where country_id=?");) {
            preparedStatement.setString(1, "AR");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("Country ID: " + resultSet.getString(1));
                    System.out.println("Country Name: " + resultSet.getString(2));
                    System.out.println("Region ID: " + resultSet.getInt(3));
                }
            } catch (Exception e) {
                System.out.println("Exception in fetching Data: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exeception occured" + e.getMessage());
        }
    }
}
