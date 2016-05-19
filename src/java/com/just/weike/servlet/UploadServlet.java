 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.servlet;

import com.just.weike.dao.DBOperate;
import com.just.weike.dao.bean.Books;
import com.just.weike.dao.bean.PositionPath;
import com.just.weike.dao.bean.TeacherBean;
import com.just.weike.service.BookDBManager;
import com.just.weike.service.DBRamTrans;
import com.just.weike.service.DocumentTranslate;
import com.just.weike.service.OfficeToXML;
import com.just.weike.service.PathFactory;
import com.just.weike.utils.Configs;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author PC
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
public class UploadServlet extends HttpServlet {

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
		PrintWriter out = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                Books book = new Books();
                String LoginName = "";
                String bookPath = "";
                String bookfolderPath = "";
                TeacherBean user = (TeacherBean) request.getSession().getAttribute("user");
                LoginName = user.getLoginname();
                if(user == null)
                    return;
                    
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024*2);
			File file =new File(Configs.BookStoreRoot);
			if (!file.exists()) {
				file.mkdir();
			}
			factory.setRepository(file);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			upload.setFileSizeMax(1024*1024*64);
			upload.setSizeMax(1024*1024*65);
			try {
				out = response.getWriter();
				System.out.println("gy");
				List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
				String filename = "";
                                System.out.println("gy");
				if (items!=null) {
					for (FileItem item:items) {
						if (item.isFormField()) {
							switch(item.getFieldName())
                                                        {
                                                            case "introduct":
                                                                String introduct = item.getString("UTF-8");
                                                                book.setIntroduct(introduct);
                                                                break;
                                                            case "classify":
                                                                String classify = item.getString("UTF-8");
                                                                //book.setIntroduct(classify);
                                                                break;
                                                        }
                                                        LoginName = item.getString("UTF-8");
							
						}else {
                                                        filename = item.getName();
                                                        filename = filename.substring(filename.lastIndexOf("\\")+1);
							System.out.println("2");
                                                        
                                                        book.setName(filename);
                                                        book.setUpLoadPerson(LoginName);
                                                        bookfolderPath = Configs.BookStoreRoot+ "\\"+ PathFactory.getBookStoreFloderName(book);
                                                        bookPath = bookfolderPath + "\\" + filename;
                                                        File folder = new File(bookfolderPath);
                                                        if(!folder.exists())
                                                            folder.mkdir();
                                                        System.out.println(bookPath);
                                                        item.write(new File(bookPath));
                                                        System.out.println(filename);
						} 
					}
				}
				//out.print("success");
				//File f = new File("E:\\tempupload\\AndroidPPT.ppt");
				//DocumentTranslate.doPPTtoImage(f);
				//out.print("success");
                                //OfficeToXML.pptToHtml(bookPath, bookfolderPath + "\\" + "ppt.html");
                                DocumentTranslate.doPPTtoImage(new File(bookPath), bookfolderPath,"raw", "jpeg", 1280, 720);
                                DocumentTranslate.doPPTtoImage(new File(bookPath), bookfolderPath,"tiny", "jpeg", 480, 320);
                               
                               
                                book.setIsNew(0);
                       
                                book.setPosition(user.getPositionPath());
                                book.setClassify(user.getClassifyPath());
                                
                                BookDBManager.addBookToDB(book, bookPath);
                                
                                out.print("success");
			} catch (Exception e) {
				// TODO: handle exception
				out.print("fail");
			}
		}
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
