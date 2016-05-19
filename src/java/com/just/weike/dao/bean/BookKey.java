/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.dao.bean;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class BookKey implements Serializable{
    private String BookName;
    private String Uploader;

    public BookKey(String BookName,String Uploader) {
        this.BookName = BookName;
        this.Uploader = Uploader;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getUploader() {
        return Uploader;
    }

    public void setUploader(String Uploader) {
        this.Uploader = Uploader;
    }
}
