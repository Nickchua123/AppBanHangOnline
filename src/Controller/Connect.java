package Controller;
    import java.sql.*;
    import javax.swing.*;
public class Connect {
    public Connection conn = null;
//Phuong thuc thuc hien ket noi CSDL
    public Connection connectSQL() throws
    SQLException{ try {
    String userName ="sa";
    String password = "123456";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=BanHangOnline;encrypt=true;trustServerCertificate=true";
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    conn = java.sql.DriverManager.getConnection(url,userName,password);
    return conn;
    }
    catch (ClassNotFoundException e) {
    JOptionPane.showMessageDialog(null,"Ket noi CSDL that bai","Thong bao",1);
    }
    return null;
    }
}
 