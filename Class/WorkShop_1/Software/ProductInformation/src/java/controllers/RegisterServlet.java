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
            String behaviour = request.getParameter("behaviour");
            System.out.println("behaviour: " + behaviour);
            String account = request.getParameter("account");
            System.out.println("account: " + account);
            String pass = request.getParameter("pass");
            System.out.println("pass: " + pass);
            String confrim = request.getParameter("confirm");
            System.out.println("confirm: " + confrim);
            String lastName = request.getParameter("lastName");
            System.out.println("lastname: " + lastName);
            String firstName = request.getParameter("firstName");
            String phone = request.getParameter("phone");
            String dob = request.getParameter("birthDay");
            Date birthDay = null;
            if (dob == null || dob.isEmpty()) {
//                    birthDay = Date.valueOf("1800-01-01");
            } else {
                birthDay = Date.valueOf(dob);
            }
            System.out.println(request.getParameter("gender"));
            int formGender = Integer.parseInt(request.getParameter("gender"));
            boolean gender = (formGender == 1) ? true : false;
            String formRole = request.getParameter("role");
            System.out.println("formGender: " + formGender);
            System.out.println("gender: " + gender);

            int roleInSystem;
            if (formRole == null || formRole.equals("Customer")) {
                roleInSystem = 0;
            } else if (formRole.equalsIgnoreCase("Administrator")) {
                roleInSystem = 1;
            } else {
                roleInSystem = 2;
            }

            int modify;
            try {
                modify = (int) session.getAttribute("modify");
            } catch (Exception e) {
                modify = 0;
            }
            boolean isActive = true;
            if (modify == 0 || behaviour.equals("register")) {
                isActive = true;
            } else if (modify == 1) {
                isActive = (Integer.parseInt(request.getParameter("isUse")) == 1) ? true : false;
            } else {

            }
            boolean isValid = true;

            if (phone == null || phone.isEmpty()) {
                isValid = true;
            } else if (phone.matches("^(84|0[3|5|7|8|9])([0-9]{8})$") == false) {
                request.setAttribute("ErrorPhoneFormat", "The phone number format is incorrect.");
                isValid = false;
            }
            if (behaviour.equals("register")) {
                if (new AccountDAO(getServletContext()).checkExist("account", account)) {
                    request.setAttribute("ExistAccount", "This username is already exist.");
                    isValid = false;
                }
                if (!pass.equals(confrim)) {
                    request.setAttribute("ConfirmFalse", "Those passwords didn’t match. Try again.");
                    isValid = false;
                }
            } else if (behaviour.equals("update")) {

            }
            if (isValid == false) {
                if (behaviour.equals("register")) {
                    request.getRequestDispatcher("MainController?action=register").forward(request, response);
                } else if (behaviour.equals("update")) {
                    request.getRequestDispatcher("MainController?action=update&account=" + account).forward(request, response);
                }
            } else {
                Account x = new Account(account, pass, firstName, lastName, birthDay, gender, phone, isActive, roleInSystem);
                if (behaviour.equals("register")) {
                    new AccountDAO(getServletContext()).insertRec(x);
                } else if (behaviour.equals("update")) {
                    new AccountDAO(getServletContext()).updateRec(x);
                }
                if (modify == 0) {
                    session.setAttribute("loginedAccount", x);
                    request.getRequestDispatcher("MainController?action=home").forward(request, response);
                    System.out.println("thanh cong tao account");
                } else {
                    request.getRequestDispatcher("MainController?action=loadListAccount").forward(request, response);
                }
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
