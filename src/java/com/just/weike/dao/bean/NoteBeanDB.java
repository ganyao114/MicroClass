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
public class NoteBeanDB extends NoteBeanBase implements Serializable{
        private BookKey book;

    public BookKey getBook() {
        return book;
    }

    public void setBook(BookKey book) {
        this.book = book;
    }
       
}
