/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mh;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NganNganchimte
 */
public class CircleCal extends HttpServlet {

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
        //--- Receive data from client
        String tmp = request.getParameter("radius");
        double r = Double.parseDouble(tmp);
        String result = "";
        if (r > 0) {
            double s = r * r * Math.PI;
            double c = 2 * r * Math.PI;
            result = "<p> Square of the circle is " + s + "</p>" +
                     "<p> Perimeter of the circle is " + c + "</p>";
        } else {
            result = "Invalid data!!!";
        }
        //---
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Result of the circle calculation</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>" + result + "</h1>");
//            out.println("<a href = 'http://localhost:8080/TheFirstServlet/circle.html'>Home page</a>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//      1.thiet la gia tri muon gui ra ben ngoai thong qua request
        request.setAttribute("result", result);
//      2.
//getRequestDispatcher: dieu huong toi dau
//forward: gui nguoc di. ham nay nhan 2 tham so la yeu cau va tra loi
        request.getRequestDispatcher("hinhtron.jsp").forward(request, response);

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
