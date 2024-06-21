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
public class BusLichHen implements CommonTask<lichHen>{
    private Connection kn;
    public BusLichHen() throws ClassNotFoundException, SQLException {
        this.kn = new ConnectDB().getConnection();
    }
    @Override
    public int add(lichHen obj) {
        int kq = 0;
        try {
            String sqlString = "insert into lichHen (account, soDT, khiNao, diaDiem, thoiGian, chiPhi, ghiChu)" +
                    "values (?,?,?,?,?,?,?)";
            PreparedStatement cmd = this.kn.prepareStatement(sqlString);
            cmd.setString(1, obj.getAccount());
            cmd.setString(2, obj.getSoDT());
            cmd.setDate(3, (Date)obj.getKhiNao());
            cmd.setString(4, obj.getDiaDiem());
            cmd.setInt(5, obj.getThoiGian());
            cmd.setInt(6, obj.getChiPhi());
            cmd.setString(7, obj.getGhiChu());
            kq = cmd.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BusLichHen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(lichHen obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(lichHen obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<lichHen> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
