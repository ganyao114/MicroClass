

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.just.weike.dao;

import com.just.weike.dao.bean.TeacherBean;
import com.just.weike.dao.bean.User;
import java.util.HashMap;
import java.util.Map;

/**
  *
 * @author PC
 */
public class StaticDataPackage {
    public static Map<String, User> UserSOnline = new HashMap<String,User>();
    public static Map<String, TeacherBean> Teachersol = new HashMap<String,TeacherBean>();
}
