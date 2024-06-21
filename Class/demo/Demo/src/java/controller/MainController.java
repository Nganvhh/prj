/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class MainController extends HttpServlet {

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
        String url = "error.jsp";
        try {
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            switch (action) {
                case "authen":
                    //---Dang nhap

                    String account = request.getParameter("account");
                    String pass = request.getParameter("pass");
                    TaiKhoan x = null;

                    //--- Kiểm tra thông tin dựa vào database
                    x = new BusTaiKhoan(getServletContext()).getTaiKhoan(account, pass);
                    //--- Nếu đăng nhập hợp lệ -> Dashboard.jsp | Sai ?-> login

                    if (x != null) {
                        session.setAttribute("ttDangNhap", x);
                        url = "dashboard.jsp";
                    } else {
                        String msg = "Invalid login";
                        request.setAttribute("ERROR", msg);
                        url = "login.jsp";
                    }
                    break;
                case "logout":
                    //---logout
                    session.invalidate();
                    url = "login.jsp";
                    break;
                case "register":
                    String first = request.getParameter("first");
                    if(first != null){
                        url = "ThemTaiKhoan.jsp";
                    } else {
                        url = "ListAccount.jsp";
                    }
                    break;
                case "list_acc":
                    List<TaiKhoan> list = (List<TaiKhoan>) new BusTaiKhoan(getServletContext()).getAll();
                    session.setAttribute("ds", list);
                    url = "ListAccount.jsp";
                    break;
                case "delete":
                    String acc = request.getParameter("key");
                    System.out.println("Key received: " + acc);
                    int kq = new BusTaiKhoan(getServletContext()).delete(acc);
                    
                    url = "MainController?action=list_acc";
                    break;
                case "update":
                    
                    break;
                default:

            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
