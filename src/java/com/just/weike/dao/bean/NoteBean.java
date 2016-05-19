package com.just.weike.dao.bean;

import java.io.Serializable;

public class NoteBean extends NoteBeanBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8704058176976419975L;
	private Books book;

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }
        
}
