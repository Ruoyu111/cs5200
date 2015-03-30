package edu.neu.cs5200.jdbc.ds.model;

import java.sql.Date;

public class Comment {
	private int idComment;
	private String comment;
	private Date date;
	public int getIdComment() {
		return idComment;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Comment(int idComment, String comment, Date date) {
		super();
		this.idComment = idComment;
		this.comment = comment;
		this.date = date;
	}
	public Comment() {
		super();
	}
	

}
