/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.service;

import com.just.weike.dao.DBOperate;
import com.just.weike.dao.bean.Books;
import com.just.weike.utils.utils;

/**
 *
 * @author gy
 */
public class BookDBManager {
    public static boolean addBookToDB(Books book,String path)
    {   
        book.setPages(BookInfoFactory.getBookPages(path));
        book.setKind(BookInfoFactory.getFileKind(path));
        book.setSize(BookInfoFactory.getFileSizeMb(path));
        book.setReadCount(0);
        book.setTokecount(0);
        book.setUploadDate(utils.getTimeNow());
        book.setAuthor("dadwa");
        DBOperate dBOperate = DBOperate.getInstance();
        dBOperate.AddBook(DBRamTrans.BookToBookDB(book));
        return true;
    }
}
