/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ProductDAO;
import dto.Account;
import dto.Product;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author NganNganchimte
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, //2MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 50 //50MB
)

public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Map<Integer, Product> mapProduct = null;
    String url = "";
    private static final String SAVE_DIRECTORY = "/images/sanPham/";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String productRequest = request.getParameter("productRequest");
            if (productRequest == null) {
                productRequest = IConstant.HOME;
            }
            switch (productRequest) {
                case IConstant.HOME:
                    url = IConstant.LINK_HOME;
                case IConstant.SHOW_PRODUCT:
                    url = IConstant.LINK_PAGE_PRODUCT;
                    break;
                case IConstant.LOAD_PRODUCT:
                    load(request, response);
                    break;
                case IConstant.ADD_PAGE_PRODUCT:
                    url = IConstant.LINK_ADD_PRODUCT;
                    break;
                case IConstant.ADD_PRODUCT:
                    add(request, response);
                    break;
                case IConstant.VALIDATION_PRODUCT:
                    validation(request, response);
                    break;
                case IConstant.DELETE_PRODUCT:
                    delete(request, response);
                    break;
                case IConstant.UPDATE_PAGE_PRODUCT:
                    repairBeforeUpdate(request, response);
                    break;
                case IConstant.VALIDATION_UPDATE_PRODUCT:
                    validationUpdate(request, response);
                    break;
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private void load(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        mapProduct = (TreeMap) new ProductDAO(getServletContext()).listAll();
        session.setAttribute("mapProduct", mapProduct);
        url = IConstant.LINK_PAGE_PRODUCT;
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");

            Product isCreatingProduct = (Product) request.getAttribute("IsCreatingProduct");
//            if (isCreatingProduct.getProductImage() == null || isCreatingProduct.getProductImage().isEmpty()) {
//                isCreatingProduct.setProductImage(SAVE_DIRECTORY);
//            } else {
//                isCreatingProduct.setProductImage(SAVE_DIRECTORY + isCreatingProduct.getProductImage());
//            }
            int result = new ProductDAO(getServletContext()).insertRec(isCreatingProduct);
            if (result != 0) {
                load(request, response);
            } else {
                url = IConstant.LINK_PAGE_PRODUCT;
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void validation(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        System.out.println("productId: " + productId);
        String productName = request.getParameter("productName");
        System.out.println("productName: " + productName);
        String productImage = request.getParameter("productImage");
        System.out.println("ProductImage: " + productImage);
        String brief = request.getParameter("brief");
        System.out.println("Brief: " + brief);
        String account = ((Account) session.getAttribute("loginedAccount")).getAccount();
        System.out.println("Account:" + account);
        int typeId;
        try {
            typeId = Integer.parseInt(request.getParameter("typeId"));
        } catch (NumberFormatException e) {
            typeId = -1;
        }
        String unit = request.getParameter("unit");
        System.out.println("Unit: " + unit);
        int price;
        try {
            price = Integer.parseInt(request.getParameter("price"));
        } catch (NumberFormatException e) {
            price = 0;
        }
        System.out.println("Price: " + price);
        int discount;
        try {
            discount = Integer.parseInt(request.getParameter("discount"));
        } catch (NumberFormatException e) {
            discount = 0;
        }
        System.out.println("Discount: " + discount);

        boolean x = new ProductDAO(getServletContext()).checkExist(productId);
        if (x) {
            request.setAttribute("ExistProductId", "This product id already exists");
            request.setAttribute("IsCreatingProduct", new Product(productId, productName, productImage, brief, typeId, account, unit, price, discount));
            url = IConstant.LINK_ADD_PRODUCT;
        } else {
            if (productImage == null || productImage.isEmpty() || brief == null || brief.isEmpty()) {
                productImage = (productImage == null || productImage.isEmpty()) ? SAVE_DIRECTORY : (SAVE_DIRECTORY + productImage);
                brief = (brief == null || brief.isEmpty()) ? "" : brief;
            }
            Product isCreatingProduct = new Product(productId, productName, productImage, brief, typeId, account, unit, price, discount);
            request.setAttribute("IsCreatingProduct", isCreatingProduct);
            add(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");
        int result = new ProductDAO(getServletContext()).deleteRec(productId);
        if (result != 0) {
            load(request, response);
        } else {
            url = IConstant.LINK_PAGE_PRODUCT;
        }
    }

    private void repairBeforeUpdate(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter("productId");
        Product updatedProduct = new ProductDAO(getServletContext()).getObjectById(productId);
        if (updatedProduct != null) {
            request.setAttribute("updatedProduct", updatedProduct);
            System.out.println("updatedProduct: " + updatedProduct.getProductImage());
            url = IConstant.LINK_UPDATE_PRODUCT;
        } else {
            url = IConstant.LINK_PAGE_PRODUCT;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        Product updatedProduct = (Product) request.getAttribute("updatedProduct");
        System.out.println("updatedProduct" + updatedProduct.getProductImage());
        int result = new ProductDAO(getServletContext()).updateRec(updatedProduct);
        if (result != 0) {
            load(request, response);
        } else {
            url = IConstant.LINK_PAGE_PRODUCT;
        }
    }

    private void validationUpdate(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String productId = request.getParameter("productId");

        String productName = request.getParameter("productName");
        String oldName = request.getParameter("oldName");

        String productImage = request.getParameter("productImage");
        System.out.println("productImage: " + productImage);
        String oldImg = request.getParameter("oldImg");
        System.out.println("oldImg: " + oldImg);
        if (productImage == null || productImage.isEmpty()) {
            productImage = oldImg;
        }
        System.out.println("productImageafter: " + productImage);
        String brief = request.getParameter("brief");
        String oldBrief = request.getParameter("oldBrief");

        int typeId;
        try {
            typeId = Integer.parseInt(request.getParameter("typeId"));
        } catch (Exception e) {
            typeId = -1;
        }
        int oldType;
        try {
            oldType = Integer.parseInt(request.getParameter("oldType"));
        } catch (Exception e) {
            oldType = -1;
        }

        String unit = request.getParameter("unit");
        String oldUnit = request.getParameter("oldUnit");
        int price;
        try {
            price = Integer.parseInt(request.getParameter("price"));

        } catch (NumberFormatException e) {
            price = 0;
        }
        int oldPrice;
        try {
            oldPrice = Integer.parseInt(request.getParameter("oldPrice"));
        } catch (Exception e) {
            oldPrice = 0;
        }

        int discount;
        try {
            discount = Integer.parseInt(request.getParameter("discount"));
        } catch (NumberFormatException e) {
            discount = 0;
        }
        int oldDiscount;
        try {
            oldDiscount = Integer.parseInt(request.getParameter("oldDiscount"));
        } catch (Exception e) {
            oldDiscount = 0;
        }

        Product updatedProduct = new Product(productId, productName, productImage, brief, typeId, oldUnit, unit, price, discount);
        request.setAttribute("updatedProduct", updatedProduct);
        if (productName.equals(oldName) && productImage.equals(oldImg) && brief.equals(oldBrief) && typeId == oldType && price == oldPrice && discount == oldDiscount) {
            url = IConstant.LINK_PAGE_PRODUCT;
        } else {
            update(request, response);
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
