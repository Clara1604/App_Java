import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Singleton {

    private static Singleton instance;
    public Connection con;


    private Singleton() throws ClassNotFoundException, SQLException {



        con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/java?user=clara&password=clara123");
        //JOptionPane.showMessageDialog(null, "Connection réussie");



    }

    public static Singleton getInstance() throws SQLException, ClassNotFoundException{
        if(instance ==null) {
            instance= new Singleton();

        }
        return instance;
    }

}

