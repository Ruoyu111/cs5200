package edu.neu.cs5200.jdbc.ds.model;

import java.sql.Date;

public class Movie {
	private int idMovie;
	private String title;
	private String posterImage;
	private Date releaseDate;
	private String movieId;
	
	public int getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPosterImage() {
		return posterImage;
	}
	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public Movie(int idMovie, String title, String posterImage,
			Date releaseDate, String movieId) {
		super();
		this.idMovie = idMovie;
		this.title = title;
		this.posterImage = posterImage;
		this.releaseDate = releaseDate;
		this.movieId = movieId;
	}
	
	public Movie() {
		super();
	}
	
}
