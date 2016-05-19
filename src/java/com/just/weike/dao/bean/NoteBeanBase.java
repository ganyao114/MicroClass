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
public class NoteBeanBase implements Serializable{
        private int page;
        private String title;
	private String authour;
	private String content;
	private int imgcounts;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthour() {
        return authour;
    }

    public void setAuthour(String authour) {
        this.authour = authour;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImgcounts() {
        return imgcounts;
    }

    public void setImgcounts(int imgcounts) {
        this.imgcounts = imgcounts;
    }
}
