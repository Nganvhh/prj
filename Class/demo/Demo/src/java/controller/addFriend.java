/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BanBe;
import model.BusBanBe;

/**
 *
 * @author NganNganchimte
 */
public class addFriend extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String soDT = request.getParameter("soDT");
            String hoTen = request.getParameter("hoTen");
            String gt = request.getParameter("gioiTinh");
            System.out.println(gt);
            Boolean gioiTinh = (gt != null) ? true : false;
//            System.out.println(request.getParameter("ngaySinh"));
            Enumeration<String> ts = request.getParameterNames();
            while (ts.hasMoreElements()) {
                System.out.println(ts.nextElement());
            }
            Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
            String diaChi = request.getParameter("diaChi");
            int loaiQuanHe = Integer.parseInt(request.getParameter("loaiQuanHe"));
            String ghiChu = request.getParameter("ghiChu");
            
            BanBe x = new BanBe(soDT, hoTen, gioiTinh, ngaySinh, diaChi, loaiQuanHe, ghiChu);
            BusBanBe b = new BusBanBe();
            int kq = b.add(x);
            if(kq > 0) {
                System.out.println("Add friend Successfully");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addFriend.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addFriend.class.getName()).log(Level.SEVERE, null, ex);
        }
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
