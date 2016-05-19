package com.just.weike.dao.bean;

import java.io.Serializable;

public class TokeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7554225630585960099L;
	
	private String Title;
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	private String Sender;
	private int Tokeid;
	private String Content;
	private String Date;
	private int Replycount;
	private int ImgCount;
        private int BookId;
        private int Page;

    public int getPage() {
        return Page;
    }

    public void setPage(int Page) {
        this.Page = Page;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

	public TokeBean() {
		// TODO Auto-generated constructor stub
	}

	public String getSender() {
		return Sender;
	}

	public void setSender(String sender) {
		Sender = sender;
	}

	public int getTokeid() {
		return Tokeid;
	}

	public void setTokeid(int tokeid) {
		Tokeid = tokeid;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getReplycount() {
		return Replycount;
	}

	public void setReplycount(int replycount) {
		Replycount = replycount;
	}

	public int getImgCount() {
		return ImgCount;
	}

	public void setImgCount(int imgCount) {
		ImgCount = imgCount;
	}

}
