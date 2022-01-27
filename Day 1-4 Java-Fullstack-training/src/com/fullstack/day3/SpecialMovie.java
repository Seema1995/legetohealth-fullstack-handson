package com.fullstack.day3;

public class SpecialMovie extends Movie {

	private String soundEffects;
	private String visualEffects;

	public SpecialMovie(String movieName, String producedBy, String soundEffects, String visualEffects) {
		super(movieName, producedBy);
		this.soundEffects = soundEffects;
		this.visualEffects = visualEffects;
	}

	public String getSoundEffects() {
		return soundEffects;
	}

	public void setSoundEffects(String soundEffects) {
		this.soundEffects = soundEffects;
	}

	public String getVisualEffects() {
		return visualEffects;
	}

	public void setVisualEffects(String visualEffects) {
		this.visualEffects = visualEffects;
	}

}
