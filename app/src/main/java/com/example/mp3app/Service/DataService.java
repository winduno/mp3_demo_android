package com.example.mp3app.Service;

import com.example.mp3app.Model.Banner;
import com.example.mp3app.Model.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("banner")
    Call<List<Banner>> getBannerData();
    @GET("playlist")
    Call<List<Playlist>> getPlaylistData();

}
