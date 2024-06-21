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
import model.BusTaiKhoan;
import model.TaiKhoan;

/**
 *
 * @author NganNganchimte
 */
public class addAccount extends HttpServlet {

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
            //--- 1/ Lấy dữ liệu dựa vào Request [Account information from client]
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String account = request.getParameter("account");
            String pass = request.getParameter("pass");
            String fullName = request.getParameter("fullName");
            //--- SimpleDateFormat - Calendar ... Để convert String thành Date
            String ns = request.getParameter("birthDay");
            Date birthDay = Date.valueOf(ns);
//            String gt = request.getParameter("gender");
            Boolean gender = (request.getParameter("gender") != null) ? true : false;
            String phone = request.getParameter("phone");
            String addr = request.getParameter("addr");
            String memo = request.getParameter("memo");
            //--- 2/- DTO TaiKhoan object
            TaiKhoan x = new TaiKhoan(account, pass, fullName, birthDay, 
                                      gender, phone, addr, memo);
            //--- 3/- Bussiness TaiKhoan
            BusTaiKhoan b = new BusTaiKhoan();
            //--- 4/- Gọi bussiness logic thi hành
            int kq = b.add(x);
            //--- 5/- Xử lý trong trường hợp thành công
            if(kq > 0) {
                System.out.println("Đã thêm 1 tài khoản vào database");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(addAccount.class.getName()).log(Level.SEVERE, null, ex);
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
