/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tv.KetNoi;

/**
 *
 * @author NganNganchimte
 */
public class TestConnection extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestConnection</title>");   
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestConnection at " + request.getContextPath() + "</h1>");
            try {
                //B1: Connect database
                KetNoi cn = new KetNoi();
                out.print("<h1 style ='color:red;'>URL String :" + cn.urlString());
                Connection connect = cn.getConnection();
                //B2: Tạo statement: viết query như SQL
                Statement cmd = connect.createStatement();
                String sqlString = "select account, pass, fullname, dob," +
                                          "gender, phone, addr, memo " +
                                   " from Taikhoan;";
                //B3: Tạo resultSet, nếu sqlString chạy được thì sẽ trả về value và gán vào resultSet, ko thì return null
                ResultSet rs = cmd.executeQuery(sqlString);
                out.print("<table>");
                out.print("<tr><th>Account</th>"
                        + "<th>Password</th>"
                        + "<th>Full name</th>"
                        + "<th>Birthday</th>"
                        + "<th>Gender</th>"
                        + "<th>Phone</th>"
                        + "<th>Address</th>"
                        + "<th>Memo</th>");
                while(rs.next()) {
                    out.print("<tr>");
                    out.print("<tr>" + rs.getString("account") + "</tr>");
                    out.print("<tr>" +rs.getString("pass") + "</tr>");
                    out.print("<tr>" +rs.getString("fullname") + "</tr>");
                    out.print("<tr>" +rs.getDate("dob") + "</tr>");
                    out.print("<tr>" +rs.getBoolean("gender") + "</tr>");
                    out.print("<tr>" +rs.getString("phone") + "</tr>");
                    out.print("<tr>" +rs.getString("addr") + "</tr>");
                    out.print("<tr>" +rs.getString("memo") + "</tr>");
                    out.print("</tr>");
                }
                out.print("</table>");
                connect.close();
                //execute: gọi khi insert into, update, delete. Hàm này sẽ return kiểu giá trị int. return 1 là đã insert update 1 dòng
                //truy vấn thì gọi executeQuery
//                Connection cn = new KetNoi().getConnection();
//                DatabaseMetaData dmd = cn.getMetaData();
//                out.print("<h3>Catalog seperator: " + dmd.getCatalogSeparator() + "</h3>");
//                out.print("<h3>Driver name:" + dmd.getDriverName() + "</h3>");
//                out.print("<h3>URL: " + dmd.getURL() + "</h3>");
//                out.print("<h3>User name: " + dmd.getUserName() + "</h3>");
            } catch (ClassNotFoundException e) {
                out.print("<h2 style= 'color:red'>" + "Sai class roi ong oi !!! </h2>");
            } catch (SQLException e) {
                out.print("<h2 style='color:violet'>Bị sai gì đó khi kết nối, đọc lại đi nhé ...<br/>" + e.getMessage());
            }
            out.println("</body>");
            out.println("</html>");
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
