package dc.human.kimbanbagi.tableJava.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

	private static final String URL = "jdbc:oracle:thin:@192.168.0.42:1521/xe";
    private static final String USER = "c##tableJava";
    private static final String PASSWORD = "tableJava";
    private static final String DRIVER_CLASS = "oracle.jdbc.OracleDriver";
        
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_CLASS);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    	
}
