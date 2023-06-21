package io;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreData {
    private String date;
    private int score;

    public ScoreData(int score){
        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date d = new Date();
    this.date = String.valueOf(formatter.format(d));

    }
    public ScoreData() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date d = new Date();
    this.date = String.valueOf(formatter.format(d));

    }
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
