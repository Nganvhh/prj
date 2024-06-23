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
import java.sql.Timestamp;
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

    public ProductDAO() {
        try {
            this.connection = new ConnectDB().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProductDAO(ServletContext sc) {
        try {
            getConnect(sc);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public int insertRec(Product obj) {
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "insert into products(productId, productName, productImage, brief, \n"
                        + "postedDate, typeId, account, unit, price, discount) \n"
                        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//                String prefix = (obj.getProductImage().equals(""))?"":"/images/sanPham/" ;
                PreparedStatement cmd;
                cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, obj.getProductId());
                cmd.setString(2, obj.getProductName());
//                cmd.setString(3, prefix + obj.getProductImage().trim());
                cmd.setString(3, obj.getProductImage().trim());
                cmd.setString(4, obj.getBrief());
                cmd.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
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
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "update products\n"
                        + "         set productName = ?, productImage = ?, brief = ?,\n"
                        + "             typeId = ?, unit = ?, price = ?, discount = ?\n"
                        + "         where productId = ?";
                String prefix = (obj.getProductImage().equals("")) ? "" : "/images/sanPham/";

                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, obj.getProductName());
                cmd.setString(2, prefix + obj.getProductImage().trim());
                cmd.setString(3, obj.getBrief());
                cmd.setInt(4, obj.getTypeId());
                cmd.setString(5, obj.getUnit());
                cmd.setInt(6, obj.getPrice());
                cmd.setInt(7, obj.getDiscount());
                cmd.setString(8, obj.getProductId());
                result = cmd.executeUpdate();
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
        return result;
    }

    @Override
    public int deleteRec(Product obj) {
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "delete from products where productId = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, obj.getProductId());
                result = cmd.executeUpdate();
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
        return result;
    }

    public int deleteRec(String id) {
        int result = 0;
        if (connection != null) {
            try {
                String sqlString = "delete from products where productId = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, id);
                result = cmd.executeUpdate();
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
        return result;
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
                    x.setPostedDate(rs.getTimestamp("postedDate"));
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

    public boolean checkExist(String id) {
        boolean isExist = false;
        if (connection != null) {
            try {
                String sqlString = "select productId from products where productId = ?";
                PreparedStatement cmd = this.connection.prepareStatement(sqlString);
                cmd.setString(1, id);
                ResultSet rs = cmd.executeQuery();
                boolean flag = true;
                while (rs.next() && flag) {
                    isExist = true;
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

        return isExist;
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
                    x.setPostedDate(rs.getTimestamp("postedDate"));
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
                    x.setPostedDate(rs.getTimestamp("postedDate"));
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
//            Product name = (Product) new ProductDAO().getObjectById("10NOTEP256");
//            System.out.println(name.getClass());
//        Map<String, Product> mapProduct = (TreeMap) new ProductDAO().listAll(2);
//        System.out.println(mapProduct.keySet());
//        for (String p : mapProduct.keySet()) {
//            System.out.println(mapProduct.get(p).getProductName());
//        }
        int result = 0;
        String img;
        result = new ProductDAO().insertRec(new Product("111", "1", "", "", 19, "admin", "Cái", 0, 0));
        System.out.println(result);

    }
}
