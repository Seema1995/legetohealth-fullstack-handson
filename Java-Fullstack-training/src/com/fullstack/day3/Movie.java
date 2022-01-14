package com.fullstack.day3;

public class Movie {
	private String movieName;
	private String producedBy;
	private String directedBy;
	private float duration;
	private int year;
	private String category;
	public static int moviesCount;
	private String movieId;

	public String getMovieId() {
		return this.getMovieName() + "_" + getMoviesCount();
	}

	public Movie(String movieName, String producedBy) {
		super();
		this.movieName = movieName;
		this.producedBy = producedBy;
	}

	public Movie(String movieName, String producedBy, String directedBy, float duration, int year, String category) {
		this(movieName, producedBy);
		this.directedBy = directedBy;
		this.duration = duration;
		this.year = year;
		this.category = category;
		moviesCount++;
	}

	public static int getMoviesCount() {
		return moviesCount;
	}

	public static void setMoviesCount(int moviesCount) {
		Movie.moviesCount = moviesCount;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getProducedBy() {
		return producedBy;
	}

	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	public String getDirectedBy() {
		return directedBy;
	}

	public void setDirectedBy(String directedBy) {
		this.directedBy = directedBy;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String showDetails() {
		return "Movie Name: " + movieName + "\r\nProduced By : " + producedBy + "\r\nDirected By : " + directedBy
				+ "\r\nDuration : " + duration + "\r\nYear : " + year + "\r\nCategory : " + category;
	}

}
