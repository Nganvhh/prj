/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import dto.Account;
import dto.Category;
import dto.Product;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        request.setCharacterEncoding("UTF-8");
        String url = "";
        Map<String, Account> mapAccount = null;
        Map<Integer, Category> mapCategory = null;
        Map<String, Product> mapProduct = null;
        String account = null;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                action = IConstant.HOME;
            }
            HttpSession session = request.getSession();

            switch (action) {
                case IConstant.HOME:
                    url = IConstant.LINK_HOME;
                    break;
                case IConstant.LOGIN:
                    String checkFirstLogin = request.getParameter("firstLogin");
                    if (checkFirstLogin == null) {
                        account = request.getParameter("account");
                        String pass = request.getParameter("pass");
                        Account x = null;
                        x = new AccountDAO(getServletContext()).checkLogin(account, pass);
                        if (x != null) {
                            if (x.getRoleInSystem() != 0) {
                                session.setAttribute("modify", 1);
                            } else {
                                session.setAttribute("modify", 0);
                            }
                            session.setAttribute("loginedAccount", x);
                            url = "homeScreen.jsp";
                        } else {
                            String msg = "Mật khẩu không đúng hoặc tài khoản không tồn tại";
                            request.setAttribute("error", msg);
                            url = "loginScreen.jsp";
                        }
                    } else {
                        url = "loginScreen.jsp";
                    }
                    break;
                case IConstant.REGISTER:
                    url = "registerScreen.jsp";
                    break;
                case "validationAccount":
                    url = "RegisterServlet";
                    break;
                case IConstant.LOGOUT:
                    session.invalidate();
                    url = "homeScreen.jsp";
                    break;
                case IConstant.CATEGORY:
                    int numericalOrder = Integer.parseInt(request.getParameter("numericalOrder"));
                    mapProduct = (TreeMap) new ProductDAO(getServletContext()).listAll(numericalOrder);
                    session.setAttribute("mapClassifiedProducts", mapProduct);
                    url = "ClassifiedProducts.jsp";
                    break;
                case "loadListCategory":
                    mapCategory = (TreeMap) new CategoryDAO(getServletContext()).listAll();
//                    System.out.println(mapCategory.get(1).getCatsegoryName());
                    session.setAttribute("mapCategory", mapCategory);
                    url = "homeScreen.jsp";
                    break;
                case "loadListProduct":
                    mapProduct = (TreeMap) new ProductDAO(getServletContext()).listAll();
                    session.setAttribute("mapProduct", mapProduct);
                    url = "homeScreen.jsp";
                    break;
                case "loadListAccount":
                    mapAccount = (HashMap) new AccountDAO(getServletContext()).listAll();
                    System.out.println("username: " + mapAccount.get("username").isIsUse());
                    session.setAttribute("mapAccount", mapAccount);
                    url = "listAccount.jsp";
                    break;
                case "showListAccount":
                    url = "listAccount.jsp";
                    break;
                case "showListCategory":
                    url = "listCategory.jsp";
                    break;
                case "showListProduct":
                    url = "listProduct.jsp";
                    break;
                case "delete":
                    account = request.getParameter("account");
//                    System.out.println("Account received: " + account);
                    new AccountDAO(getServletContext()).delete(account);
                    url = "MainController?action=loadListAccount";
                    break;
                case "state":
                    account = request.getParameter("account");
                    new AccountDAO(getServletContext()).changeState(account);
                    url = "MainController?action=loadListAccount";
                    break;
                case "update":
                        account = request.getParameter("account");
                        Account updatedAccount = new AccountDAO(getServletContext()).getObjectById(account);
                        request.setAttribute("updatedAccount", updatedAccount);
                        url = "updateAccount.jsp";
                    break;
                default:
                    break;
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
