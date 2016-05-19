/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */

package com.just.weike.dao;


import com.just.weike.dao.bean.BookDB;
import com.just.weike.dao.bean.Books;
import com.just.weike.dao.bean.ClassifyPath;
import com.just.weike.dao.bean.PositionPath;
import com.just.weike.dao.bean.TeacherBean;
import com.just.weike.dao.bean.TokeBean;
import com.just.weike.dao.bean.User;
import com.just.weike.dao.bean.UserDB;
import com.just.weike.dao.bean.UserInfoPrivate;
import com.just.weike.service.DBRamTrans;
import com.just.weike.utils.Configs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;

public class DBOperate {
    
    private final static DBOperate dBOperate = new DBOperate();
    private final String DRIVER = "com.hxtt.sql.access.AccessDriver";
    private final String DBURL = "jdbc:Access:///" + Configs.DataBasePath;
    //private final String ACCOUNT = "postgres";
    //private final String PASSWORD = "123";
    
    public static DBOperate getInstance()
    {
        return dBOperate;
    }
    
    public DBOperate() {
    }

    //杩炴帴鏁版嵁搴�
    public Connection CreateConn() {
        try {
            Class.forName(DRIVER).newInstance();
            Connection conn
                    = DriverManager.getConnection(DBURL);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   

    //鍏抽棴鏁版嵁搴�
    public void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(String loginID) {
        User user = null;
        Connection conn = CreateConn();
        if (conn == null) {
            return user;
        }

        try {
            Statement st = conn.createStatement();
            // System.out.println("SELECT COUNT(*) FROM t_user where username='"+loginID+"'");
           // ResultSet Rs = st.executeQuery("SELECT COUNT(*) FROM t_user where username='" + loginID + "'");
            String sql = "SELECT * FROM User where loginname='" + loginID + "'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                user = new User();
                user.setUsername(loginID);
                user.setPassword(rs.getString("loginpassword"));
                user.setEmail(rs.getString("mail"));
                JSONObject positionobj = JSONObject.fromObject(rs.getString("positionpath"));
                PositionPath position = new PositionPath();
                position.setCollege(positionobj.getString("college"));
                position.setSubject(positionobj.getString("subject"));
                position.setGrade(positionobj.getString("grade"));
                user.setPosition(position);
            }
            rs.close();
            st.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);

        return user;
    }
    
    public TeacherBean getTeacher(String loginname)
    {
        TeacherBean user = null;
        Connection conn = CreateConn();
        if (conn == null) {
            return user;
        }

        try {
            Statement st = conn.createStatement();
            // System.out.println("SELECT COUNT(*) FROM t_user where username='"+loginID+"'");
           // ResultSet Rs = st.executeQuery("SELECT COUNT(*) FROM t_user where username='" + loginID + "'");
            String sql = "SELECT * FROM Teachers where teachername='" + loginname + "'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                user = new TeacherBean();
                user.setLoginname(loginname);
                user.setPasswd(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                JSONObject positionobj = JSONObject.fromObject(rs.getString("positionpath"));
                PositionPath position = new PositionPath();
                position.setCollege(positionobj.getString("college"));
                position.setSubject(positionobj.getString("subject"));
                position.setGrade(positionobj.getString("grade"));
                user.setPositionPath(position);
                JSONObject classifyobj = JSONObject.fromObject(rs.getString("classifypaths"));
                ClassifyPath classify = new ClassifyPath();
                classify.setMain(classifyobj.getString("main"));
                classify.setSub(classifyobj.getString("sub"));
                classify.setSub2(classifyobj.getString("sub2"));
                user.setClassifyPath(classify);
            }
            rs.close();
            st.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);

        return user;
    }

    public void DoReginster(String username, String pwd, String email,String positionpath) {
        Connection conn = CreateConn();
        if (conn == null) {
            return;
        }
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM User where loginname='" + username + "'";
            Statement sta = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 0) {
                String Sql = "insert into User(loginname,loginpassword,mail,positionpath) values('" + username + "','" + pwd + "','" + email + "','" + positionpath +"')";
                System.out.println(Sql);
                st.execute(Sql);
                st.close();
            } else {
                
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);

        return;
    }
    
    public void AddStudent(UserDB user)
    {
        
    }
    
    public void AddBook(BookDB book)
    {
        Connection conn = CreateConn();
        if (conn == null) {
            return;
        }
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM Books where bookname='" + book.getName() + "'";
            Statement sta = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 0) {
                String Sql = "insert into Books(bookname,uploader,author,size,pages,filekind,introduct,positionpath,classifypath,readcount,tokecount,uploaddate,isnew) values('" + book.getName() + "','" + book.getUpLoadPerson() + "','" 
                        + book.getAuthor() + "','" + book.getSize() + "','" + book.getPages() + "','" + book.getKind()+ "','" + book.getIntroduct() + "','" + book.getPosition() 
                       + "','" + book.getClassifyPath() +"','" + book.getReadCount() + "','" + book.getTokecount() + "','" + book.getUploadDate() + "','" + book.getIsNew() + "')";
                System.out.println(Sql);
                st.execute(Sql);
                st.close();
            } else {
                
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);

        return;
    }
    
    public boolean AddTeacher()
    {
        return true;
    }
    
    public Books GetBook()
    {
        return null;
    }
    
    public List<Books> GetBookListByClassify()
    {
        return null;
    }
    
    public List<Books> GetBookListByPosition(PositionPath path)
    {   
        List<Books> books = new ArrayList<Books>();
        JSONObject pathobject = new JSONObject();
        pathobject.put("college", path.getCollege());
        pathobject.put("subject", path.getSubject());
        pathobject.put("grade", path.getGrade());
        String pathstring = pathobject.toString();
        pathstring = pathstring.substring(1, pathstring.length() - 2);
        Connection conn = CreateConn();
        if (conn == null) {
            return books;
        }

        try {
            Statement st = conn.createStatement();
            // System.out.println("SELECT COUNT(*) FROM t_user where username='"+loginID+"'");
           // ResultSet Rs = st.executeQuery("SELECT COUNT(*) FROM t_user where username='" + loginID + "'");
            String sql = "SELECT * FROM Books where positionpath like '" + "%" + pathstring + "%" + "'";
           // System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                BookDB bookdb = new BookDB();
                bookdb.setName(rs.getString("bookname"));
                bookdb.setId(rs.getInt("id"));
                bookdb.setAuthor(rs.getString("author"));
                bookdb.setIsNew(rs.getInt("isnew"));
                bookdb.setIntroduct(rs.getString("introduct"));
                bookdb.setUploadDate(rs.getString("uploaddate"));
                bookdb.setUpLoadPerson(rs.getString("uploader"));
                bookdb.setPages(rs.getInt("pages"));
                bookdb.setKind(rs.getString("filekind"));
                bookdb.setClassifyPath(rs.getString("classifypath"));
                bookdb.setPosition(rs.getString("positionpath"));
                bookdb.setSize(rs.getString("size"));
                books.add(DBRamTrans.BookDBToRam(bookdb));
            }
            rs.close();
            st.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);

        return books;
    }
    
    public List<Books> GetMainPageBookList()
    {
        return null;
    }
   
    public List<Books> GetSaveBooks()
    {
        return null;
    }
    
    public boolean AddToke(TokeBean toke)
    {
         Connection conn = CreateConn();
        if (conn == null) {
            return false;
        }
        try {
            Statement st = conn.createStatement();
            Statement sta = conn.createStatement();
            int count = 0;
            if (count == 0) {
                String Sql = "insert into Tokes(bookid,title,content,sender,date,replycount,imgs,page) values('" + toke.getBookId() + "','" + toke.getTitle() + "','" 
                            + toke.getContent() + "','" + toke.getSender() + "','" + toke.getDate() + "','" + toke.getReplycount() + "','" + toke.getImgCount() + "','" + toke.getPage() + "')";
                System.out.println(Sql);
                st.execute(Sql);
                st.close();
            } else {
                
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);

        return true;
    }
    
    public List<TokeBean> GetTokes(Books book,int page)
    {   
        List<TokeBean> tokes = new ArrayList<TokeBean>();
        Connection conn = CreateConn();
        if (conn == null) {
            return tokes;
        }

        try {
            Statement st = conn.createStatement();
            // System.out.println("SELECT COUNT(*) FROM t_user where username='"+loginID+"'");
           // ResultSet Rs = st.executeQuery("SELECT COUNT(*) FROM t_user where username='" + loginID + "'");
            String sql = "SELECT * FROM Tokes where bookid='" + book.getId() + "'" + " and page='" + page +"'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                TokeBean toke = new TokeBean();
                toke.setBookId(rs.getInt("bookid"));
                toke.setTitle(rs.getString("title"));
                toke.setContent(rs.getString("content"));
                toke.setDate(rs.getString("date"));
                toke.setImgCount(rs.getInt("imgs"));
                toke.setReplycount(rs.getInt("replycount"));
                toke.setSender(rs.getString("sender"));
                tokes.add(toke);
            }
            rs.close();
            st.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConn(conn);
        return tokes;
    }
}
