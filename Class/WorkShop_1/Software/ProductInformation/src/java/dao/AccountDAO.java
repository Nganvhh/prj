/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import utilities.ConnectDB;

/**
 *
 * @author NganNganchimte
 */
public class AccountDAO implements Accessible<Account> {

    private ServletContext sc;
    private Connection connection;

    public AccountDAO() throws ClassNotFoundException, SQLException {
        this.connection = new ConnectDB().getConnection();
    }

    public AccountDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        String hostName = sc.getInitParameter("host");
        String instance = sc.getInitParameter("instance");
        String port = sc.getInitParameter("port");
        String dbName = sc.getInitParameter("DbName");
        String user = sc.getInitParameter("user");
        String password = sc.getInitParameter("password");
        this.connection = new ConnectDB(hostName, port, dbName, user, password, instance).getConnection();
    }

    @Override
    public int insertRec(Account obj) {
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "insert into accounts(account, pass, lastName, "
                        + "firstName, birthday, gender, phone, isUse, roleInSystem)\n"
                        + "values (?,?,?,?,?,?,?,?,?)";
                PreparedStatement cmd;

                cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, obj.getAccount());
                cmd.setString(2, obj.getPass());
                cmd.setString(3, obj.getLastName());
                cmd.setString(4, obj.getFirstName());
                cmd.setDate(5, obj.getBirthDay());
                cmd.setBoolean(6, obj.isGender());
                cmd.setString(7, obj.getPhone());
                cmd.setBoolean(8, obj.isIsUse());
                cmd.setInt(9, obj.getRoleInSystem());

                result = cmd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int updateRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete(String acc) {
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "delete from accounts where account = ?";
                PreparedStatement cmd;
                cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, acc);
                result = cmd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public Account getObjectById(String id) {
        Account x = null;
        if (connection != null) {
            try {
                Statement cmd = this.connection.createStatement();
                String sqlString = "select account, pass, lastName, firstName, birthday, \n"
                        + "gender, phone, isUse, roleInSystem \n"
                        + "from accounts where account = '" + id + "'";
                ResultSet rs = cmd.executeQuery(sqlString);
                boolean flag = true;
                while (rs.next() && flag) {
                    x = new Account();
                    x.setAccount(rs.getString("account"));
                    x.setPass(rs.getString("pass"));
                    x.setLastName(rs.getString("lastName"));
                    x.setFirstName(rs.getString("firstName"));
                    x.setBirthDay(rs.getDate("birthday"));
                    x.setGender(rs.getBoolean("gender"));
                    x.setPhone(rs.getString("phone"));
                    x.setIsUse(rs.getBoolean("isUse"));
                    x.setRoleInSystem(rs.getInt("roleInSystem"));
                    flag = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return x;
    }

    public boolean checkExist(String field, String value) {
        boolean checkExits = false;
        if (connection != null) {
            try {
                Statement cmd = this.connection.createStatement();
                String sqlString = "select account, pass, lastName, firstName, birthday, \n"
                        + "gender, phone, isUse, roleInSystem \n"
                        + "from accounts where " + field + " = '" + value + "'";
                ResultSet rs = cmd.executeQuery(sqlString);
                boolean flag = true;
                while (rs.next() && flag) {
                    checkExits = true;
                    flag = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return checkExits;
    }

    @Override
    public Map<?, Account> listAll() {
        Map<String, Account> map = new HashMap();
        if (connection != null) {
            try {
                Statement cmd = this.connection.createStatement();

                String sqlString = "select account, pass, lastName, firstName, \n"
                        + "birthday, gender, phone, isUse, roleInSystem \n"
                        + "from accounts";

                ResultSet rs = cmd.executeQuery(sqlString);

                while (rs.next()) {
                    Account x = new Account();
                    x.setAccount(rs.getString("account"));
                    x.setPass(rs.getString("pass"));
                    x.setLastName(rs.getString("lastName"));
                    x.setFirstName(rs.getString("firstName"));
                    x.setBirthDay(rs.getDate("birthday"));
                    x.setGender(rs.getBoolean("gender"));
                    x.setPhone(rs.getString("phone"));
                    x.setIsUse(rs.getBoolean("isUse"));
                    x.setRoleInSystem(rs.getInt("roleInSystem"));
                    map.put(x.getAccount(), x);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    public int changeState(String id) {
        int result = 0;
        if (connection != null) {
            try {
//                Statement cmd = this.connection.createStatement();
                String sqlString = "select account, isUse from accounts where account = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, id);
                ResultSet rs = cmd.executeQuery();
                boolean flag = true;
                boolean oldStatus = false;
                while (rs.next() && flag) {
                    oldStatus = rs.getBoolean("isUse");
                    flag = false;
                }
                boolean newStatus = (oldStatus==false?true:false);
                sqlString = "update accounts\n"
                        + "set isUse = ?\n"
                        + "where account = ?";
                cmd = this.connection.prepareStatement(sqlString);
                cmd.setBoolean(1, newStatus);
                cmd.setString(2, id);
                result = cmd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }

    public Account checkLogin(String id, String pass) {
        Account x = null;
        if (connection != null) {
            try {
//                Statement cmd = this.connection.createStatement();
                String sqlString = "select account, pass, lastName, firstName, birthday, \n"
                        + "gender, phone, isUse, roleInSystem \n"
                        + "from accounts where account = ? and pass = ? and isUse = 1";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, id);
                cmd.setString(2, pass);
                ResultSet rs = cmd.executeQuery();
                boolean flag = true;
                while (rs.next() && flag) {
                    x = new Account();
                    x.setAccount(rs.getString("account"));
                    x.setPass(rs.getString("pass"));
                    x.setLastName(rs.getString("lastName"));
                    x.setFirstName(rs.getString("firstName"));
                    x.setBirthDay(rs.getDate("birthday"));
                    x.setGender(rs.getBoolean("gender"));
                    x.setPhone(rs.getString("phone"));
                    x.setIsUse(rs.getBoolean("isUse"));
                    x.setRoleInSystem(rs.getInt("roleInSystem"));
                    flag = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return x;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int x = new AccountDAO().changeState("test");
        System.out.println(x);
        Account a = new AccountDAO().getObjectById("test");
        System.out.println("isUse: " + a.isIsUse());
//        System.out.println(x.getAccount());
//        Map<String, Account> mapAccount = (HashMap) new AccountDAO().listAll();
//        System.out.println(mapAccount.get("admin").getAccount());
        

    }

}
