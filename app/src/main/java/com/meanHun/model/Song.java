package com.meanHun.model;

import java.io.Serializable;

public class Song implements Serializable {
    private String idSong;
    private String name_Song;
    private String theloai;
    private String name_Singer;
    private boolean state;

    public Song(String id, String name_Song, String theloai, String name_Singer, boolean state) {
        this.idSong = id;
        this.name_Song = name_Song;
        this.theloai = theloai;
        this.name_Singer = name_Singer;
        this.state = state;
    }

    public String getidSong() {
        return idSong;
    }

    public void setidSong(String id) {
        this.idSong = id;
    }

    public String getName_Song() {
        return name_Song;
    }

    public void setName_Song(String name_Song) {
        this.name_Song = name_Song;
    }

    public String getSince() {
        return theloai;
    }

    public void setSince(String since) {
        this.theloai = since;
    }

    public String getName_Singer() {
        return name_Singer;
    }

    public void setName_Singer(String name_Singer) {
        this.name_Singer = name_Singer;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
