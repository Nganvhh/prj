/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CategoryDAO;
import dto.Category;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CategoryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Map<Integer, Category> mapCategory = null;
    String url = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String category = request.getParameter("category");
            if (category == null) {
                category = IConstant.HOME;
            }
            switch (category) {
                case IConstant.ADD_PAGE_CATEGORY:
                    url = IConstant.LINK_ADD_CATEGORY;
                    break;
                case IConstant.LOAD_CATEGORY:
                    load(request, response);
                    break;
                case IConstant.SHOW_CATEGORY:
                    url = IConstant.LINK_PAGE_CATEGORY;
                    break;
                case IConstant.ADD_CATEGORY:
                    add(request, response);
                    break;
                case IConstant.VALIDATION_CATEGORY:
                    validation(request, response);
                    break;
                case IConstant.DELETE_CATEGORY:
                    delete(request, response);
                    break;
                case IConstant.UPDATE_PAGE_CATEGORY:
                    repairBeforeUpdate(request, response);
                    break;
                case IConstant.VALIDATION_UPDATE_CATEGORY:
                    validationUpdate(request, response);
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

    private void load(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        mapCategory = (TreeMap) new CategoryDAO(getServletContext()).listAll();
        session.setAttribute("mapCategory", mapCategory);
        url = IConstant.LINK_PAGE_CATEGORY;
    }
    
    private void add(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String categoryName = request.getParameter("categoryName");
        String memo  = request.getParameter("memo");
        int result = new CategoryDAO(getServletContext()).insertRec(new Category(categoryName, memo));
        if(result != 0){
            load(request, response);
        } else {
            url = IConstant.LINK_PAGE_CATEGORY;
        }
    }
    
    private void validation(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String categoryName = request.getParameter("categoryName");
        String memo = request.getParameter("memo");
        boolean x = new CategoryDAO(getServletContext()).checkExistCategoryName(categoryName);
        if(x) {
            request.setAttribute("ExistCategoryName", "This category name already exists");
            request.setAttribute("IsCreatingCategory", new Category(categoryName, memo));
            url = IConstant.LINK_ADD_CATEGORY;
        } else {
            add(request, response);
        }
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        int result = new CategoryDAO(getServletContext()).delete(typeId);
        if(result != 0) {
            load(request, response);
        } else {
            url = IConstant.LINK_PAGE_CATEGORY;
        }
    }
    
    private void repairBeforeUpdate(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String typeId = request.getParameter("typeId");
        Category updatedCategory = new CategoryDAO(getServletContext()).getObjectById(typeId);
        if(updatedCategory != null) {
            request.setAttribute("updatedCategory", updatedCategory);
            url = IConstant.LINK_UPDATE_CATEGORY;
        } else {
            url = IConstant.LINK_PAGE_CATEGORY;
        }
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response) {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String categoryName = request.getParameter("categoryName");
        String memo = request.getParameter("memo");
        int result = new CategoryDAO(getServletContext()).updateRec(new Category(typeId, categoryName, memo));
        if(result != 0){
            System.out.println(typeId);
            load(request, response);
        } else {
            url = IConstant.LINK_PAGE_CATEGORY;
        }
    }
    
    private void validationUpdate(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String categoryName = request.getParameter("categoryName");
        String nameBeforeUpdate = request.getParameter("nameBeforeUpdate");
        String memo = request.getParameter("memo");
        String memoBeforeUpdate = request.getParameter("memoBeforeUpdate");
        
        if(categoryName.equals(nameBeforeUpdate)){
            if(memo.equals(memoBeforeUpdate)) {
                url = IConstant.LINK_PAGE_CATEGORY;
            } else {
                update(request, response);
            }
        } else {
            boolean x = new CategoryDAO(getServletContext()).checkExistCategoryName(categoryName);
            if(x) {
                request.setAttribute("ExistCategoryName", "This category name already exists");
                request.setAttribute("updatedCategory", new Category(categoryName, memo));
                url = IConstant.LINK_ADD_CATEGORY;
            } else {
                update(request, response);
            }
        }
    }
    
    

}
