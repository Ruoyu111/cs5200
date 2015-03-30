package edu.neu.cs5200.jdbc.ds.model;

import java.sql.Date;

public class Actor {
	private int idActor;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String actorId;
	public int getIdActor() {
		return idActor;
	}
	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public Actor(int idActor, String firstName, String lastName,
			Date dateOfBirth, String actorId) {
		super();
		this.idActor = idActor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.actorId = actorId;
	}
	public Actor() {
		super();
	}
	
}
