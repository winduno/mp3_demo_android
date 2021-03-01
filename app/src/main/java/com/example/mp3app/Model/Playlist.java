package com.example.mp3app.Model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Playlist implements Serializable {

    @SerializedName("playlistId")
    @Expose
    private Integer playlistId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("backGround")
    @Expose
    private String backGround;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("songs")
    @Expose
    private List<Song> songs = null;

    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackGround() {
        return backGround;
    }

    public void setBackGround(String backGround) {
        this.backGround = backGround;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}