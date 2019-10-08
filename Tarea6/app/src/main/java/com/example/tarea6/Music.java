package com.example.tarea6;

public class Music {

    private String name;
    private String artist;
    private String url;

    public Music(String name, String artist, String url) {
        this.name = name;
        this.artist = artist;
        this.url = url;
    }

    public String getName() {
        return name;
    }


    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }
}
