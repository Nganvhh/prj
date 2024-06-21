/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import utilities.ConnectDB;

/**
 *
 * @author NganNganchimte
 */
public class CategoryDAO implements Accessible<Category> {

    private Connection connection;

    public CategoryDAO() throws ClassNotFoundException, SQLException {
        this.connection = new ConnectDB().getConnection();
    }

    public CategoryDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        getConnect(sc);
    }

    private Connection getConnect(ServletContext sc) throws ClassNotFoundException, SQLException {
        String hostName = sc.getInitParameter("host");
        String instance = sc.getInitParameter("instance");
        String port = sc.getInitParameter("port");
        String dbName = sc.getInitParameter("DbName");
        String user = sc.getInitParameter("user");
        String password = sc.getInitParameter("password");
        this.connection = new ConnectDB(hostName, port, dbName, user, password, instance).getConnection();
        return connection;
    }

    @Override
    public int insertRec(Category obj) {
        int result = 0;
        if (this.connection != null) {
            try {
                String sqlString = "insert into categories(typeId, categoryName, memo) \n"
                        + "values (?, ?, ?)";
                PreparedStatement cmd;
                cmd = this.connection.prepareStatement(sqlString);
                cmd.setInt(1, obj.getTypeId());
                cmd.setString(2, obj.getCategoryName());
                cmd.setString(3, obj.getMemo());
                result = cmd.executeUpdate();
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
        return result;
    }

    @Override
    public int updateRec(Category obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteRec(Category obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, Category> listAll() {
        Map<Integer, Category> map = new TreeMap();
        if (connection != null) {
            try {
                Statement cmd;
                cmd = this.connection.createStatement();
                String sqlString = "select typeId, categoryName, memo from categories";
                ResultSet rs = cmd.executeQuery(sqlString);
                while (rs.next()) {
                    Category x = new Category();
                    x.setTypeId(rs.getInt("typeId"));
                    x.setCategoryName(rs.getString("categoryName"));
                    x.setMemo(rs.getString("memo"));
                    map.put(x.getTypeId(), x);
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

    public static void main(String[] args) {
        try {
            Map<Integer, Category> mapCategory = (TreeMap<Integer, Category>) new CategoryDAO().listAll();
            System.out.println(mapCategory.get(1).getCategoryName());
            for (Integer i : mapCategory.keySet()) {
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
