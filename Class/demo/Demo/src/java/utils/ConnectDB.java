package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author NganNganchimte
 */
public class ConnectDB {

    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String hostName; //IP address
    private String port;
    private String dbName;
    private String userName;
    private String password;
    private String instanceName;
    /**
     * Default constructor
     */
    public ConnectDB() {
        this.instanceName = "NGANNGANCHIMTE\\NGANCUTE";
        this.hostName = "localhost";
        this.port = "1433";
        this.dbName = "lichHen";
        this.userName = "sa";
        this.password = "ngan123";
    }

    public ConnectDB(String hostName, String port, String dbName, String userName, String password, String instanceName) {
        this.hostName = hostName;
        this.port = port;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.instanceName = instanceName;
    }
    
    public String urlString() {
        return String.format("jdbc:sqlserver://%s%s:%s;DatabaseName=%s;UserName=%s;Password=%s;",
                this.hostName, (this.instanceName.length()>0?"\\" + this.instanceName : ""), 
                this.port, this.dbName, this.userName, this.password);
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connect = null;
        Class.forName(this.driver);
        connect = DriverManager.getConnection(urlString());
        return connect;
//        try {
//            Class.forName(driver);
//            return DriverManager.getConnection(urlString());
//        } catch (ClassNotFoundException ex) {
//            System.out.println("fail1");
//            Logger.getLogger(KetNoi.class).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            System.out.println("fail2");
//            Logger.getLogger(KetNoi.class).log(Level.SEVERE, null, ex);
//        }
//        return null;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectDB connectionDemo = new ConnectDB();
        System.out.println(connectionDemo.getConnection()==null?"éo kết nối":"Kết nối nè");
    }
    
}
