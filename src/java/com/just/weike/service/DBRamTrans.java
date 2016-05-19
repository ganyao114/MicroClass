/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.service;

import com.just.weike.dao.bean.BookDB;
import com.just.weike.dao.bean.BookKey;
import com.just.weike.dao.bean.Books;
import com.just.weike.dao.bean.ClassifyPath;
import com.just.weike.dao.bean.NoteBeanDB;
import com.just.weike.dao.bean.PositionPath;
import com.just.weike.dao.bean.User;
import com.just.weike.dao.bean.UserDB;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author PC
 */
public class DBRamTrans {
    
    public static UserDB UserToDBUser(User user)
    {   
        UserDB userdb = new UserDB();
        userdb.setUsername(user.getUsername());
        userdb.setPassword(user.getPassword());
        userdb.setEmail(user.getEamil());
        List<BookKey> savebooks = new ArrayList<BookKey>();
        for(int i = 0;i < user.getSavebooks().size();i++)
            savebooks.add(new BookKey(user.getSavebooks().get(i).getName(),user.getSavebooks().get(i).getUpLoadPerson()));
        JSONArray savebooksarrary = JSONArray.fromObject(savebooks);
        userdb.setSavebooks(savebooksarrary.toString());
        JSONArray replysarrary = JSONArray.fromObject(user.getTokereplys());
        userdb.setTokereplys(replysarrary.toString());
        JSONArray tokesarrary = JSONArray.fromObject(user.getTokes());
        userdb.setTokes(tokesarrary.toString());
        List<NoteBeanDB> notebeandbs = new ArrayList<NoteBeanDB>();
        for(int i = 0;i < user.getNotes().size();i++){
            NoteBeanDB bean = new NoteBeanDB();
            bean.setAuthour(user.getNotes().get(i).getAuthour());
            bean.setBook(new BookKey(user.getNotes().get(i).getBook().getName(),user.getNotes().get(i).getBook().getUpLoadPerson()));
            bean.setContent(user.getNotes().get(i).getContent());
            bean.setImgcounts(user.getNotes().get(i).getImgcounts());
            bean.setTitle(user.getNotes().get(i).getTitle());
        }
        JSONArray notebeanArrary = JSONArray.fromObject(notebeandbs);
        userdb.setNotes(notebeanArrary.toString());
        return userdb;
    }
    
    public static User UserDBToUser(UserDB userdb)
    {
        return null;
    }
    
    public static String BooksToDB(List<Books> books)
    {   
        JSONArray arary = JSONArray.fromObject(books);
        return arary.toString();
    }
    
    public static BookDB BookToBookDB(Books book)
    {
        BookDB bookdb = new BookDB();
        bookdb.setAuthor(book.getAuthor());
        bookdb.setId(book.getId());
        bookdb.setIntroduct(book.getIntroduct());
        bookdb.setIsNew(book.getIsNew());
        bookdb.setKind(book.getKind());
        bookdb.setName(book.getName());
        bookdb.setPages(book.getPages());
        bookdb.setReadCount(book.getReadCount());
        bookdb.setSize(book.getSize());
        bookdb.setUpLoadPerson(book.getUpLoadPerson());
        bookdb.setUploadDate(book.getUploadDate());
        JSONObject positinobject = new JSONObject();
        positinobject.put("college", book.getPosition().getCollege());
        positinobject.put("subject", book.getPosition().getSubject());
        positinobject.put("grade", book.getPosition().getGrade());
        bookdb.setPosition(positinobject.toString());
        JSONObject classifyobject = new JSONObject();
        classifyobject.put("main", book.getClassify().getMain());
        classifyobject.put("sub", book.getClassify().getSub());
        classifyobject.put("sub2", book.getClassify().getSub2());
        bookdb.setClassifyPath(classifyobject.toString());
        return bookdb;
    }
    
    public static Books BookDBToRam(BookDB bookdb)
    {   
        Books bookram = new Books(); 
        bookram.setAuthor(bookdb.getAuthor());
        bookram.setId(bookdb.getId());
        bookram.setIntroduct(bookdb.getIntroduct());
        bookram.setIsNew(bookdb.getIsNew());
        bookram.setKind(bookdb.getKind());
        bookram.setName(bookdb.getName());
        bookram.setPages(bookdb.getPages());
        bookram.setReadCount(bookdb.getReadCount());
        bookram.setSize(bookdb.getSize());
        bookram.setUpLoadPerson(bookdb.getUpLoadPerson());
        bookram.setUploadDate(bookdb.getUploadDate());
        JSONObject positionpathobj = JSONObject.fromObject(bookdb.getPosition());
        bookram.setPosition(new PositionPath(positionpathobj.getString("college"), positionpathobj.getString("subject"), positionpathobj.getString("grade")));
        JSONObject classifyobj = JSONObject.fromObject(bookdb.getClassifyPath());
        bookram.setClassify(new ClassifyPath(classifyobj.getString("main"),classifyobj.getString("sub"), classifyobj.getString("sub2")));
        return bookram;
    }
    
}
