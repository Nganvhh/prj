/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import utilities.ConnectDB;

/**
 *
 * @author NganNganchimte
 */
public class ProductDAO implements Accessible<Product> {

    private Connection connection;

    public ProductDAO() throws ClassNotFoundException, SQLException {
        this.connection = new ConnectDB().getConnection();
    }

    public ProductDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
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
    public int insertRec(Product obj) {
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "insert into products(productId, productName, productImage, brief, \n"
                        + "postedDate, typeId, account, unit, price, discount) \n"
                        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement cmd;
                cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, obj.getProductId());
                cmd.setString(2, obj.getProductName());
                cmd.setString(3, obj.getProductImage());
                cmd.setString(4, obj.getBrief());
                cmd.setDate(5, obj.getPostedDate());
                cmd.setInt(6, obj.getTypeId());
                cmd.setString(7, obj.getAccount());
                cmd.setString(8, obj.getUnit());
                cmd.setInt(9, obj.getPrice());
                cmd.setInt(10, obj.getDiscount());
                result = cmd.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int updateRec(Product obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteRec(Product obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getObjectById(String id) {
        Product x = null;
        if (connection != null) {
            try {
                String sqlString = "select productId, productName, productImage, brief, \n"
                        + "postedDate, typeId, account, unit, price, discount\n"
                        + "from products where productId = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, id);
                ResultSet rs = cmd.executeQuery();
                boolean flag = true;
                while (rs.next() && flag) {
                    x = new Product();
                    x.setProductId(rs.getString("productId"));
                    x.setProductName(rs.getString("productName"));
                    x.setProductImage(rs.getString("productImage"));
                    x.setBrief(rs.getString("brief"));
                    x.setPostedDate(rs.getDate("postedDate"));
                    x.setTypeId(rs.getInt("typeId"));
                    x.setAccount(rs.getString("account"));
                    x.setUnit(rs.getString("unit"));
                    x.setPrice(rs.getInt("price"));
                    x.setDiscount(rs.getInt("discount"));
                    flag = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public Map<String, Product> listAll() {
        Map<String, Product> map = new TreeMap();
        if (connection != null) {
            try {
                Statement cmd = this.connection.createStatement();
                String sqlString = "select productId, productName, productImage, brief, \n"
                        + "postedDate, typeId, account, unit, price, discount\n"
                        + "from products";
                ResultSet rs = cmd.executeQuery(sqlString);
                while (rs.next()) {
                    Product x = new Product();
                    x.setProductId(rs.getString("productId"));
                    x.setProductName(rs.getString("productName"));
                    x.setProductImage(rs.getString("productImage"));
                    x.setBrief(rs.getString("brief"));
                    x.setPostedDate(rs.getDate("postedDate"));
                    x.setTypeId(rs.getInt("typeId"));
                    x.setAccount(rs.getString("account"));
                    x.setUnit(rs.getString("unit"));
                    x.setPrice(rs.getInt("price"));
                    x.setDiscount(rs.getInt("discount"));
                    map.put(x.getProductId(), x);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public Map<String, Product> listAll(int categoryId) {
        Map<String, Product> map = new TreeMap();
        if (connection != null) {
            try {
                Statement cmd = this.connection.createStatement();
                String sqlString = "select productId, productName, productImage, brief, \n"
                        + "postedDate, typeId, account, unit, price, discount\n"
                        + "from products where typeId = " + categoryId + "";
                ResultSet rs = cmd.executeQuery(sqlString);
                while (rs.next()) {
                    Product x = new Product();
                    x.setProductId(rs.getString("productId"));
                    x.setProductName(rs.getString("productName"));
                    x.setProductImage(rs.getString("productImage"));
                    x.setBrief(rs.getString("brief"));
                    x.setPostedDate(rs.getDate("postedDate"));
                    x.setTypeId(rs.getInt("typeId"));
                    x.setAccount(rs.getString("account"));
                    x.setUnit(rs.getString("unit"));
                    x.setPrice(rs.getInt("price"));
                    x.setDiscount(rs.getInt("discount"));
                    map.put(x.getProductId(), x);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//            Product name = (Product) new ProductDAO().getObjectById("10NOTEP256");
//            System.out.println(name.getClass());
            Map<String, Product> mapProduct = (TreeMap) new ProductDAO().listAll(2);
            System.out.println(mapProduct.keySet());
            for (String p : mapProduct.keySet()) {
                System.out.println(mapProduct.get(p).getProductName());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
