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
public class TeacherBean implements Serializable{
    
    private String loginname;
    private String passwd;
    private PositionPath positionPath;
    private ClassifyPath classifyPath;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public PositionPath getPositionPath() {
        return positionPath;
    }

    public void setPositionPath(PositionPath positionPath) {
        this.positionPath = positionPath;
    }

    public ClassifyPath getClassifyPath() {
        return classifyPath;
    }

    public void setClassifyPath(ClassifyPath classifyPath) {
        this.classifyPath = classifyPath;
    }

   
    
}
