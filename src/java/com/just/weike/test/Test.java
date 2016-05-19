/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.test;

import com.just.weike.dao.DBOperate;
import com.just.weike.dao.bean.Books;
import com.just.weike.dao.bean.PositionPath;
import com.just.weike.dao.bean.TokeBean;
import com.just.weike.utils.utils;
import java.util.List;


/**
 *
 * @author gy
 */
public class Test {
    public static void main(String[] args) {
        DBOperate dBOperate = DBOperate.getInstance();
        Books book = new Books();
        book.setId(3);
        List<TokeBean> tokes = dBOperate.GetTokes(book,1);
        System.out.println(tokes.get(0).getContent());
    }
}
