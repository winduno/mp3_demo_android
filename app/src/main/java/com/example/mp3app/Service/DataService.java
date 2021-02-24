package com.example.mp3app.Service;

import com.example.mp3app.Model.Album;
import com.example.mp3app.Model.Banner;
import com.example.mp3app.Model.Playlist;
import com.example.mp3app.Model.Song;
import com.example.mp3app.Model.Type;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("banner")
    Call<List<Banner>> getBannerData();
    @GET("playlist")
    Call<List<Playlist>> getPlaylistData();
    @GET("type")
    Call<List<Type>> getTypeData();
    @GET("album")
    Call<List<Album>> getAlbumData();
    @GET("song/like")
    Call<List<Song>> getSongByLikeData();

}
