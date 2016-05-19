/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.service;

import com.just.weike.dao.DBOperate;
import com.just.weike.dao.bean.TeacherBean;
import com.just.weike.dao.bean.User;
import com.just.weike.dao.bean.UserInfoPrivate;


/**
 *
 * @author Administrator
 */
public class UserLogin {
    public static User login(String username,String pwd)
    {
        if(username == null || username.isEmpty()
                || pwd == null || pwd.isEmpty())
        {
            return null;
        }
        DBOperate dbo = DBOperate.getInstance();
        User user = dbo.getUser(username); 
         
        if(user == null)
            return null;
        
        if(user.getUsername().equals(username)&&
                user.getPassword().equals(pwd))
        {
            return user;
        }
        return null;
    }
    
    public static TeacherBean teacherLogin(String username,String pwd)
    {
        if(username == null || username.isEmpty()
                || pwd == null || pwd.isEmpty())
        {
            return null;
        }
        DBOperate dbo = DBOperate.getInstance();
        TeacherBean user = dbo.getTeacher(username); 
         
        if(user == null)
            return null;
        
        if(user.getLoginname().equals(username)&&
                user.getPasswd().equals(pwd))
        {
            return user;
        }
        return null;
    }
}
