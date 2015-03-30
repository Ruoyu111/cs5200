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

import edu.neu.cs5200.jdbc.ds.model.Movie;

public class MovieDAO {
	
	DataSource ds;
	
	public MovieDAO()
	{
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDataSourceAssignmentDB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// create a movie
	public void createMovie(Movie newMovie)
	{
		String sql = "insert into movie values(null,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newMovie.getTitle());
			statement.setString(2, newMovie.getPosterImage());
			statement.setDate(3, newMovie.getReleaseDate());
			statement.setString(4, newMovie.getMovieId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return;
	}
	// read all movies
	public List<Movie> readAllMovies()
	{
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "select * from movie";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Movie movie = new Movie();
				movie.setIdMovie(results.getInt("idMovie"));
				movie.setTitle(results.getString("title"));
				movie.setPosterImage(results.getString("posterImage"));
				movie.setReleaseDate(results.getDate("releaseDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
	
	// read a movie by idMovie
	public Movie readMovie(int idMovie)
	{
		Movie movie = new Movie();
		
		String sql = "select * from movie where idMovie = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idMovie);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				movie.setIdMovie(result.getInt("idMovie"));
				movie.setTitle(result.getString("title"));
				movie.setPosterImage(result.getString("posterImage"));
				movie.setReleaseDate(result.getDate("releaseDate"));
				movie.setMovieId(result.getString("movieId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movie;
	}
	
	// update a movie by id
	public void updateMovie(int idMovie, Movie movie)
	{
		String sql = "update movie set title=?, posterImage=?, releaseDate=?, movieId=? where idMovie=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getPosterImage());
			statement.setDate(3, movie.getReleaseDate());
			statement.setString(4, movie.getMovieId());
			statement.setInt(5, idMovie);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// delete a movie by id
	public void deleteMovie(int idMovie)
	{
		String sql = "delete from movie where idMovie=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idMovie);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}