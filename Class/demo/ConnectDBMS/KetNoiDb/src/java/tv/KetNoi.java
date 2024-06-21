/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tv;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author NganNganchimte
 */
public class KetNoi {

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
    public KetNoi() {
        this.instanceName = "NGANNGANCHIMTE\\NGANCUTE";
        this.hostName = "localhost";
        this.port = "1433";
        this.dbName = "Test1";
        this.userName = "docdl";
        this.password = "123456";
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
        KetNoi connectionDemo = new KetNoi();
        connectionDemo.getConnection();
    }
    
}
