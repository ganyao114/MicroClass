package com.just.weike.dao.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class User implements Serializable{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String email;
    private PositionPath position;
    private List<Books> savebooks;
    private List<TokeBean> tokes;
    private List<ReplyBean> tokereplys;
    private List<NoteBean> notes;

    public User() {
    }
    
    
    
    public List<NoteBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteBean> notes) {
        this.notes = notes;
    }

    public List<TokeBean> getTokes() {
        return tokes;
    }

    public void setTokes(List<TokeBean> tokes) {
        this.tokes = tokes;
    }

    public List<ReplyBean> getTokereplys() {
        return tokereplys;
    }

    public void setTokereplys(List<ReplyBean> tokereplys) {
        this.tokereplys = tokereplys;
    }

    public List<Books> getSavebooks() {
        return savebooks;
    }

    public void setSavebooks(List<Books> savebooks) {
        this.savebooks = savebooks;
    }

    public PositionPath getPosition() {
        return position;
    }

    public void setPosition(PositionPath position) {
        this.position = position;
    }
   
    public User(String username,String password,String email){
    	this.username = username;
    	this.password = password;
    	this.email = email;
    	
    	
    }
    public String getUsername()
    {
        return username;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEamil()
    {
        return email;
    }
	
    public String getEmail() {
            return email;
    }
    public void setUsername(String username) {
	this.username = username;
    }
}

