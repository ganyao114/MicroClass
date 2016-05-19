/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.servlet;

import com.just.weike.dao.DBOperate;
import com.just.weike.dao.bean.PositionPath;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author PC
 */
@WebServlet(name = "RegistServlet", urlPatterns = {"/RegistServlet"})
public class RegistServlet extends HttpServlet {

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
		String name = request.getParameter("LoginName");
		String passwd = request.getParameter("LoginPassword");
		String mail = request.getParameter("Mail");
                String college = request.getParameter("College");
                String subject = request.getParameter("Subject");
                String grade = request.getParameter("Grade");

	         if(name == null || name.isEmpty()
	                || passwd == null || passwd.isEmpty()
	                ||mail == null || mail.isEmpty()
                         ||college == null || college.isEmpty()
                         ||subject == null || subject.isEmpty()
                         ||grade == null || grade.isEmpty())
	        {
	            return;
	        }
                
               JSONObject object = new JSONObject();
               object.put("college", college);
               object.put("subject", subject);
               object.put("grade", grade);
	       DBOperate dbo = DBOperate.getInstance();
	       dbo.DoReginster(name,passwd,mail,object.toString());
	        System.out.println(name);
			System.out.println(passwd);
			System.out.println(mail);
	        out.print("success");
	        return;		
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
