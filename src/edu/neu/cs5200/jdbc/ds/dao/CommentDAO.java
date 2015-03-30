package edu.neu.cs5200.jdbc.ds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.cs5200.jdbc.ds.model.Comment;

public class CommentDAO {
	DataSource ds;
	public CommentDAO()
	{
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDataSourceAssignmentDB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// create a comment
	public void createComment(Comment newComment)
	{
		String sql = "insert into comment values(null,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getComment());
			statement.setDate(2, newComment.getDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return;
	}
	
	// read all comments
	public List<Comment> readAllComments()
	{
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from comment";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}
	// read all comments for username
	public List<Comment> readAllCommentsForUsername(String username)
	{
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from comment, user where user.username = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}
	
	// read all comments for movie
	public List<Comment> readAllCommentsForMovie(int idMovie)
	{
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from comment, movie where movie.idMovie = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idMovie);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}
	
	// read a comment by idComment
	public Comment readCommentForId(int idComment)
	{
		Comment comment = new Comment();
		
		String sql = "select * from comment where idComment = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idComment);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				comment.setComment(result.getString("comment"));
				comment.setDate(result.getDate("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comment;
	}
	
	// update a comment by idComment
	public void updateComment(int idComment, Comment comment)
	{
		String sql = "update comment set comment=?, date=? where idComment=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, comment.getComment());
			statement.setDate(2, comment.getDate());
			statement.setInt(3, idComment);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// delete a comment by id
	public void deleteComment(int idComment)
	{
		String sql = "delete from comment where idComment=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idComment);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
