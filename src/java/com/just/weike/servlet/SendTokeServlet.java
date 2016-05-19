/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.servlet;

import com.just.weike.dao.DBOperate;
import com.just.weike.dao.StaticDataPackage;
import com.just.weike.dao.bean.TokeBean;
import com.just.weike.dao.bean.User;
import com.just.weike.utils.utils;
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
@WebServlet(name = "SendTokeServlet", urlPatterns = {"/SendTokeServlet"})
public class SendTokeServlet extends HttpServlet {

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
            String loginname = request.getParameter("LoginName");
            JSONObject tokeobj = JSONObject.fromObject(request.getParameter("Toke"));
            User user = StaticDataPackage.UserSOnline.get(loginname);
            if(user == null){
                out.write("unlogin");
            }
            System.out.println(tokeobj.toString());
            TokeBean toke = new TokeBean();
            toke.setBookId(tokeobj.getInt("Bookid"));
            toke.setPage(tokeobj.getInt("Page"));
            toke.setContent(tokeobj.getString("Content"));
            toke.setSender(loginname);
            toke.setTitle(tokeobj.getString("Title"));
            toke.setDate(utils.getTimeNow());
            toke.setImgCount(0);
            toke.setReplycount(0);
            DBOperate dbo = DBOperate.getInstance();
            if(dbo.AddToke(toke)){
                out.write("sucesses");
            }else{
                out.write("failed");
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
