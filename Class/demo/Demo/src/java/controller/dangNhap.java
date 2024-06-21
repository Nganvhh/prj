/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BusTaiKhoan;
import model.TaiKhoan;

/**
 *
 * @author NganNganchimte
 */
public class dangNhap extends HttpServlet {

    private final String LOGIN = "login.jsp";
    private final String DASHBOARD = "dashboard.jsp";

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
        try (PrintWriter out = response.getWriter()) {
            //--- Nhận thông tin đăng nhập gửi về từ client
            String account = request.getParameter("account");
            String pass = request.getParameter("pass");
            TaiKhoan x = null;
            try {
                //--- Kiểm tra thông tin dựa vào database
                x = new BusTaiKhoan(getServletContext()).getTaiKhoan(account, pass);
                //--- Nếu đăng nhập hợp lệ -> Dashboard.jsp | Sai ?-> login
                HttpSession session = request.getSession();
                if (x != null) {
                    session.setAttribute("ttDangNhap", x);
                    response.sendRedirect(DASHBOARD);
                } else {
                    String msg = "Invalid login";
                    request.setAttribute("ERROR", msg);
                    request.getRequestDispatcher(LOGIN).forward(request, response);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(dangNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(dangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }

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
