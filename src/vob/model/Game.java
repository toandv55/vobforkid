package vob.model;

import vob.annotation.NonMapped;

@NonMapped
public class Game {
	private int score;
	private int time;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}
