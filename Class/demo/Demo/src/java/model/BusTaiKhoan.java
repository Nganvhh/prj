/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import utils.ConnectDB;

/**
 *
 * @author NganNganchimte
 */
public class BusTaiKhoan implements CommonTask<TaiKhoan> {

    private Connection kn;

    public BusTaiKhoan() throws ClassNotFoundException, SQLException {
        this.kn = new ConnectDB().getConnection();
    }

    public BusTaiKhoan(ServletContext sc) throws ClassNotFoundException, SQLException {
        //-- Đọc thong số kết nối từ Web Descriptor (web.xml) dựa trên ServletContext
        String hostName = sc.getInitParameter("host");
        String instance = sc.getInitParameter("instance");
        String port = sc.getInitParameter("port");
        String dbName = sc.getInitParameter("DbName");
        String user = sc.getInitParameter("user");
        String password = sc.getInitParameter("password");
        //-- Tạo Connection
        this.kn = new ConnectDB(hostName, port, dbName, user, password, instance).getConnection();
    }

    @Override
    public int add(TaiKhoan obj) {
        int kq = 0;
        try {
            //-- 1: Tạo mẫu sql string [Tương ứng với lệnh muốn chạy trên SQL Server]
            String sqlString = "insert into taiKhoan(account, pass, fullName, dob, gender, phone, addr, memo) "
                    + "values (?,?,?,?,?,?,?,?);";
            //-- 2: Tạo đối tượng PrepraredStatement dựa vào Connection
            PreparedStatement cmd = this.kn.prepareStatement(sqlString);
            //-- 3: Truyền giá trị vào mẫu SQL String ở trên
            cmd.setString(1, obj.getAccount());
            cmd.setString(2, obj.getPass());
            cmd.setString(3, obj.getFullName());
            cmd.setDate(4, (Date) obj.getDob());
            cmd.setBoolean(5, obj.isGender());
            cmd.setString(6, obj.getPhone());
            cmd.setString(7, obj.getAddr());
            cmd.setString(8, obj.getMemo());
            //-- 4: Gọi thi hành lệnh
            kq = cmd.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BusTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(TaiKhoan obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(TaiKhoan obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete(String acc) {
        int kq = 0;
        try {
            String sqlString = "delete from taiKhoan where account = ?";
            PreparedStatement cmd = this.kn.prepareStatement(sqlString);
            cmd.setString(1, acc);
            kq = cmd.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BusTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public List<TaiKhoan> getAll() {
        List<TaiKhoan> l = new ArrayList();
        try {
            //--- 1. Taoj statement object
            Statement cmd = this.kn.createStatement();
            //--- 2. Tạo query string để truy vấn database
            String sqlString = "select account, pass, fullName, dob, gender, phone, addr, memo "
                    + "from taiKhoan";
            //--- 3. Ra lệnh, nhận kết quả từ Database server
            ResultSet rs = cmd.executeQuery(sqlString);
            //--- 4. Lặp để nhận dữ liệu
            while (rs.next()) {
                //--- 4.1 Tạo TaiKhoan object
                TaiKhoan x = new TaiKhoan();
                //--- 4.2 Lấy thông ti từ ResultSet, và gán cho TaiKhoan object
                x.setAccount(rs.getString("account"));
                x.setPass(rs.getString("pass"));
                x.setFullName(rs.getString("fullName"));
                x.setDob(rs.getDate("dob"));
                x.setGender(rs.getBoolean("gender"));
                x.setPhone(rs.getString("phone"));
                x.setAddr(rs.getString("addr"));
                x.setMemo(rs.getString("memo"));
                //--- 4.3 Gắn TaiKhoan object vào list<TaiKhoan>
                l.add(x);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BusTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public TaiKhoan getTaiKhoan(String acc, String pas) {
        TaiKhoan k = null;
        try {
            //--- 1. Taoj statement object
            Statement cmd = this.kn.createStatement();
            //--- 2. Tạo query string để truy vấn database
            String sqlString = "select account, pass, fullName, dob, gender, phone, addr, memo "
                    + "from taiKhoan where account = '" + acc.trim() + "' and pass = '" + pas.trim() + "'";
            //--- 3. Ra lệnh, nhận kết quả từ Database server
            ResultSet rs = cmd.executeQuery(sqlString);
            //--- 4. Lặp để nhận dữ liệu
            boolean flag = true;
            while (rs.next() && flag) {
                //--- 4.1 Tạo TaiKhoan object
                k = new TaiKhoan();
                //--- 4.2 Lấy thông ti từ ResultSet, và gán cho TaiKhoan object
                k.setAccount(rs.getString("account"));
                k.setPass(rs.getString("pass"));
                k.setFullName(rs.getString("fullName"));
                k.setDob(rs.getDate("dob"));
                k.setGender(rs.getBoolean("gender"));
                k.setPhone(rs.getString("phone"));
                k.setAddr(rs.getString("addr"));
                k.setMemo(rs.getString("memo"));
                //--- thoát thôi
                flag = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BusTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (kn != null) {
                    kn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return k;
    }

}
