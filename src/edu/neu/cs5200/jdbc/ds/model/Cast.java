package edu.neu.cs5200.jdbc.ds.model;

public class Cast {
	private int idCast;
	private String characterName;
	public int getIdCast() {
		return idCast;
	}
	public void setIdCast(int idCast) {
		this.idCast = idCast;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public Cast(int idCast, String characterName) {
		super();
		this.idCast = idCast;
		this.characterName = characterName;
	}
	public Cast() {
		super();
	}
	

}
