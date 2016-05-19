/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.servlet;

import com.just.weike.dao.DBOperate;
import com.just.weike.dao.StaticDataPackage;
import com.just.weike.dao.bean.Books;
import com.just.weike.dao.bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;

/**
 *
 * @author PC
 */
@WebServlet(name = "GetBookListServlet", urlPatterns = {"/GetBookListServlet"})
public class GetBookListServlet extends HttpServlet {

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
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
        String loginname = request.getParameter("LoginName");
        String cmd = "default";//request.getParameter("Cmd");
        User user = StaticDataPackage.UserSOnline.get(loginname);
        if(user == null){
            out.write("unlogined");
            return;
        }
        switch(cmd)
        {
            case "default":
                 DBOperate dBOperate = DBOperate.getInstance();
                 List<Books> books = dBOperate.GetBookListByPosition(user.getPosition());
                 System.out.println(books.size());
                 JSONArray array = JSONArray.fromObject(books);
                 System.out.println(array.toString());
                 out.write(array.toString());
                break;
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
