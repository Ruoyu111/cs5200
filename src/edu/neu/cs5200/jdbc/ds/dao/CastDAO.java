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

import edu.neu.cs5200.jdbc.ds.model.Cast;

public class CastDAO {
	DataSource ds;
	public CastDAO()
	{
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDataSourceAssignmentDB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// create a cast
		public void createCast(Cast newCast)
		{
			String sql = "insert into cast values(null,?)";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, newCast.getCharacterName());
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return;
		}
		
		// read all casts
		public List<Cast> readAllCasts()
		{
			List<Cast> casts = new ArrayList<Cast>();
			String sql = "select * from cast";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Cast cast = new Cast();
					cast.setCharacterName(results.getString("characterName"));;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return casts;
		}
		// read all casts for actor
		public List<Cast> readAllCastsForActor(int idActor)
		{
			List<Cast> casts = new ArrayList<Cast>();
			String sql = "select * from cast, actor where actor.idActor = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idActor);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Cast cast = new Cast();
					cast.setCharacterName(results.getString("characterName"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return casts;
		}
		
		// read all casts for movie
		public List<Cast> readAllCastsForMovie(int idMovie)
		{
			List<Cast> casts = new ArrayList<Cast>();
			String sql = "select * from cast, movie where movie.idMovie = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idMovie);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Cast cast = new Cast();
					cast.setCharacterName(results.getString("characterName"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return casts;
		}
		
		// read a cast by idCast
		public Cast readCastForId(int idCast)
		{
			Cast cast = new Cast();
			
			String sql = "select * from cast where idCast = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idCast);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					cast.setCharacterName(result.getString("characterName"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cast;
		}
		
		// update a cast by idCast
		public void updateCast(int idCast, Cast cast)
		{
			String sql = "update cast set characterName=? where idCast=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, cast.getCharacterName());
				statement.setInt(2, idCast);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// delete a cast by id
		public void deleteCast(int idCast)
		{
			String sql = "delete from cast where idCast=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idCast);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
