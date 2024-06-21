/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectDB;

/**
 *
 * @author NganNganchimte
 */
public class BusBanBe implements CommonTask<BanBe>{
    private Connection kn;
    public BusBanBe() throws ClassNotFoundException, SQLException {
        this.kn = new ConnectDB().getConnection();
    }
    @Override
    public int add(BanBe obj) {
        int kq = 0;
        try {
            //-- 1: Tạo mẫu sql string [Tương ứng với lệnh muốn chạy trên SQL Server]
            String sqlString = "insert into banBe(soDT, hoTen, gioiTinh, ngaySinh, diaChi, loaiQuanHe, ghiChu) " + 
                                "values (?,?,?,?,?,?,?)";
            //-- 2: Tạo đối tượng PrepraredStatement dựa vào Connection
            PreparedStatement cmd = this.kn.prepareStatement(sqlString);
            //-- 3: Truyền giá trị vào mẫu SQL String ở trên
            cmd.setString(1, obj.getSoDT());
            cmd.setString(2, obj.getHoTen());
            cmd.setBoolean(3, obj.isGioiTinh());
            cmd.setDate(4, (Date) obj.getNgaySinh());
            cmd.setString(5, obj.getDiaChi());
            cmd.setInt(6, obj.getLoaiQuanHe());
            cmd.setString(7, obj.getGhiChu());
            //-- 4: Gọi thi hành lệnh
            kq = cmd.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BusTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(BanBe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(BanBe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BanBe> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
