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

import edu.neu.cs5200.jdbc.ds.model.Actor;

public class ActorDAO {
DataSource ds;
	
	public ActorDAO()
	{
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/JDBCDataSourceAssignmentDB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// create an actor
		public void createActor(Actor newActor)
		{
			String sql = "insert into actor values(null,?,?,?,?)";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, newActor.getFirstName());
				statement.setString(2, newActor.getLastName());
				statement.setDate(3, newActor.getDateOfBirth());
				statement.setString(4, newActor.getActorId());
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return;
		}
		// read all actors
		public List<Actor> readAllActors()
		{
			List<Actor> actors = new ArrayList<Actor>();
			String sql = "select * from actor";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Actor actor = new Actor();
					actor.setFirstName(results.getString("firstName"));
					actor.setLastName(results.getString("lastName"));
					actor.setDateOfBirth(results.getDate("dateOfBirth"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return actors;
		}
		
		// read an actor by idActor
		public Actor readActor(int idActor)
		{
			Actor actor = new Actor();
			
			String sql = "select * from actor where idActor = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idActor);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					actor.setFirstName(result.getString("firstName"));
					actor.setLastName(result.getString("lastName"));
					actor.setDateOfBirth(result.getDate("dateOfBirth"));
					actor.setActorId(result.getString("actorId"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return actor;
		}
		
		// update a actor by idActor
		public void updateActor(int idActor, Actor actor)
		{
			String sql = "update actor set firstName=?, lastName=?, dateOfBirth=?, actorId=? where idActor=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, actor.getFirstName());
				statement.setString(2, actor.getLastName());
				statement.setDate(3, actor.getDateOfBirth());
				statement.setString(4, actor.getActorId());
				statement.setInt(5, idActor);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// delete an actor by idActor
		public void deleteActor(int idActor)
		{
			String sql = "delete from actor where idActor=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idActor);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
