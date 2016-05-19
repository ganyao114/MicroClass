/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.service;

import com.just.weike.dao.bean.Books;

/**
 *
 * @author PC
 */
public class PathFactory {
    public static String getBookStoreFloderName(Books book)
    {
        return book.getName() + '-' + book.getUpLoadPerson();
    }
}
