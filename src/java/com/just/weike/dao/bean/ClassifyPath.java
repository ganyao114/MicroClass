/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.dao.bean;

import java.io.Serializable;

/**
 *
 * @author gy
 */
public class ClassifyPath implements Serializable{
    private String main;
    private String sub;
    private String sub2;

    public ClassifyPath(String main,String sub,String sub2) {
        this.main = main;
        this.sub = sub;
        this.sub2 = sub2;
    }

    public ClassifyPath() {
    }
    
    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getSub2() {
        return sub2;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }
    
    
    
}
