/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NganNganchimte
 */
public class RegisterServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample co{e. */
            try {
                String account = request.getParameter("account");
                String pass = request.getParameter("pass");
                String confrim = request.getParameter("confirm");
                String lastName = request.getParameter("lastName");
                String firstName = request.getParameter("firstName");
                String phone = request.getParameter("phone");
                String dob = request.getParameter("birthDay");
                Date birthDay = null;
                if (dob == null || dob.isEmpty()) {
                    birthDay = Date.valueOf("1800-01-01");
                } else {
                    birthDay = Date.valueOf(dob);
                }
                int formGender = Integer.parseInt(request.getParameter("gender"));
                boolean gender = (formGender == 1) ? true : false;
                String formRole = request.getParameter("role");
                System.out.println("formGender: " + formGender);
                System.out.println("gender: " + gender);
                
                int roleInSystem;
                if (formRole == null) {
                    roleInSystem = 0;
                } else if (formRole.equalsIgnoreCase("Administrator")) {
                    roleInSystem = 1;
                } else {
                    roleInSystem = 2;
                }
                boolean isActive = true;
                
                boolean isValid = true;
                
                if (phone == null || phone.isEmpty()){
                    isValid = true;
                } else if (phone.matches("^(84|0[3|5|7|8|9])([0-9]{8})$") == false) {
                    System.out.println("phone sai");
                    request.setAttribute("ErrorPhoneFormat", "The phone number format is incorrect.");
                    isValid = false;
                }
                if (new AccountDAO(getServletContext()).checkExist("account", account)) {
                    System.out.println("acc trùng");
                    request.setAttribute("ExistAccount", "This username is already exist.");
                    isValid = false;
                }
                if (!pass.equals(confrim)) {
                    System.out.println("pass ko khớp");
                    request.setAttribute("ConfirmFalse", "Those passwords didn’t match. Try again.");
                    isValid = false;
                }
                if (isValid == false) {
                    request.getRequestDispatcher("MainController?action=register").forward(request, response);
                } else {
                    Account x = new Account(account, pass, firstName, lastName, birthDay, gender, phone, isActive, roleInSystem);
                    new AccountDAO(getServletContext()).insertRec(x);
                    if (roleInSystem == 0) {
                        session.setAttribute("loginedAccount", x);
                        request.getRequestDispatcher("MainController?action=home").forward(request, response);
                        System.out.println("thanh cong tao account");
                    } else {
                        request.getRequestDispatcher("MainController?action=showListAccount");
                    }
                }

            } catch (ClassNotFoundException ex) {
                System.out.println("exception r");
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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