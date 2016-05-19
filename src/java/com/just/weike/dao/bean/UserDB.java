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
public class UserDB implements Serializable{
    private String username;
    private String password;
    private String email;
    private String position;
    private String savebooks;
    private String tokes;
    private String tokereplys;
    private String notes;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSavebooks() {
        return savebooks;
    }

    public void setSavebooks(String savebooks) {
        this.savebooks = savebooks;
    }

    public String getTokes() {
        return tokes;
    }

    public void setTokes(String tokes) {
        this.tokes = tokes;
    }

    public String getTokereplys() {
        return tokereplys;
    }

    public void setTokereplys(String tokereplys) {
        this.tokereplys = tokereplys;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
