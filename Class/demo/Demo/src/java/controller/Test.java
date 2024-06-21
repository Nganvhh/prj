/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BanBe;
import model.BusBanBe;
import model.BusTaiKhoan;
import model.TaiKhoan;

/**
 *
 * @author NganNganchimte
 */
public class Test extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        TaiKhoan o = new TaiKhoan("2222222222", "Hoang Thanh Tuan", new Date(0, 0, 0), "0909887766", "Nga tu Thu Duc", )
        try {
            TaiKhoan o = new TaiKhoan("linhlac", "123456", "Tran Quan Minh", Date.valueOf("2004-08-08"), true, "0913112233", "Thủ đức", "");
            BusTaiKhoan x = new BusTaiKhoan(getServletContext());
            System.out.println(x.getAll());
//            int kq = x.add(o);
//            if (kq == 1) {
//                System.out.println("Successfully");
//            }
//            BanBe b = new BanBe("0123654789", "sample", false, Date.valueOf("2004-08-08"), " ", 0, "");
//            BusBanBe bb = new BusBanBe();
//            kq = bb.add(b);
//            if (kq == 1) {
//                System.out.println("Add friend Successfully");
//            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BusTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BusTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }

        String hostName= getServletContext().getInitParameter("host").toString();
        System.out.println("Host name: " + hostName);
//        String instance = getServletContext().getInitParameter("instance").toString();
//        System.out.println("Instance: " + instance);
//        String port = getServletContext().getInitParameter("port").toString();
//        System.out.println("Port: " + port);
//        String dbName = getServletContext().getInitParameter("DbName").toString();
//        System.out.println("Database Name: " + dbName);
//        String user = getServletContext().getInitParameter("user");
//        System.out.println("User: " + user);
//        String password = getServletContext().getInitParameter("password");
//        System.out.println("Password: " + password);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
