package com.just.weike.dao.bean;

import java.io.Serializable;

public class Books extends BookBase implements Serializable{
	
	private static final long serialVersionUID = 212617952715550351L;
	
	public PositionPath Position;
        public ClassifyPath Classify;

    public ClassifyPath getClassify() {
        return Classify;
    }

    public void setClassify(ClassifyPath Classify) {
        this.Classify = Classify;
    }
	
	public Books() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PositionPath getPosition() {
		return Position;
	}
	public void setPosition(PositionPath position) {
		Position = position;
	}
	
}
