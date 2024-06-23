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

    public CategoryDAO(ServletContext sc) {
        try {
            getConnect(sc);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                String sqlString = "insert into categories(categoryName, memo) \n"
                        + "values (?, ?)";
                PreparedStatement cmd;
                cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, obj.getCategoryName());
                cmd.setString(2, obj.getMemo());
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
        int result = 0;
        if (connection != null) {
            try {
                
                String sqlString = "update categories\n"
                        + "         set categoryName = ?, memo = ?\n"
                        + "         where typeId = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, obj.getCategoryName());
                cmd.setString(2, obj.getMemo());
                cmd.setInt(3, obj.getTypeId());
                result = cmd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    public int deleteRec(Category obj) {
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "delete from categories\n"
                        + "where typeId = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setInt(1, obj.getTypeId());
                result = cmd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public int delete(int id) {
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "delete from categories\n"
                        + "where typeId = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setInt(1, id);
                result = cmd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    public Category getObjectById(String id) {
        Category x = null;
        if (connection != null) {
            try {
                int typteId = Integer.parseInt(id);
                String sqlString = "select typeId, categoryName, memo \n"
                        + "from categories\n"
                        + "where typeId = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setInt(1, typteId);
                ResultSet rs = cmd.executeQuery();
                boolean flag = true;
                while (rs.next() && flag) {
                    x = new Category();
                    x.setTypeId(typteId);
                    x.setCategoryName(rs.getString("categoryName"));
                    x.setMemo(rs.getString("memo"));
                    flag = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    
    public boolean checkExistCategoryName(String name) {
        boolean isExist = false;
        if (connection != null) {
            try {
                String sqlString = "select categoryName from categories where categoryName = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, name);
                ResultSet rs = cmd.executeQuery();
                boolean flag = true;
                while (rs.next() && flag) {
                    isExist = true;
                    flag = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return isExist;
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
