package com.music.model;
import java.io.Serializable;

public class MusicItem implements Serializable {
    private String title;
    private String year;
    private String genre;
    private String artist; 
    
    public MusicItem(String title, String year, String genre, String artist) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
