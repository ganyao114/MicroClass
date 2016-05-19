/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.servlet;

import com.just.weike.dao.StaticDataPackage;
import com.just.weike.dao.bean.TeacherBean;
import com.just.weike.dao.bean.User;
import com.just.weike.service.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gy
 */
@WebServlet(name = "TeacherLogin", urlPatterns = {"/TeacherLogin"})
public class TeacherLogin extends HttpServlet {

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
	response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        response.setContentType("text/html;charset=UTF-8");   
	response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String loginname = request.getParameter("LoginName");
        String passwd = request.getParameter("LoginPassword");
        
        if (loginname == null || loginname.isEmpty()
                || passwd == null || passwd.isEmpty()) {
            //response.sendRedirect("login.jsp");
        } else {
            
            TeacherBean user = UserLogin.teacherLogin(loginname, passwd);
            if (user == null) {
                out.print("failed");
                return;
            }
            
            
            
            if(StaticDataPackage.Teachersol.get(loginname)!=null)
            {
                out.print("logined");
                return;
            }
            
            StaticDataPackage.Teachersol.put(loginname, user);
            request.getSession().setAttribute("user", user);  
           response.sendRedirect(request.getContextPath() + "/UploadBook.jsp");
            
     
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
