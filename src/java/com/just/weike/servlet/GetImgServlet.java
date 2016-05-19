/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.servlet;

import com.just.weike.dao.StaticDataPackage;
import com.just.weike.utils.Configs;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "GetImgServlet", urlPatterns = {"/GetImgServlet"})
public class GetImgServlet extends HttpServlet {

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
                request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=UTF-8");
                InputStream in=null;
		OutputStream out = null;
		request.setCharacterEncoding("UTF-8");
      
		String subpath = request.getParameter("Url");
                String LoginName = request.getParameter("LoginName");
                
                System.out.println(subpath);
                
                if(StaticDataPackage.UserSOnline.get(LoginName) == null)
                    return;
		String truepath = Configs.BookStoreRoot + "\\" + subpath;
             
		try {
			in = new FileInputStream(new File(truepath));
			response.setContentType("image/jpeg");
			out = response.getOutputStream();
			int read = 0;
			byte[] b = new byte[1024];
			while ((read = in.read(b)) != -1) {
				out.write(b,0,read);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if (in!=null) {
				in.close();
			}if (out!=null) {
				out.close();
			}
		}
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    }

