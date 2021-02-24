package com.example.mp3app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.Adapter.HotSongAdapter;
import com.example.mp3app.Model.Song;
import com.example.mp3app.R;
import com.example.mp3app.Service.APIService;
import com.example.mp3app.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHotSong extends Fragment {

    View view;
    ArrayList<Song> songArrayList;
    RecyclerView recyclerViewHotSong;
    HotSongAdapter hotSongAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_song_by_like, container, false);
        recyclerViewHotSong = view.findViewById(R.id.recyclerviewHotSong);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getSongByLikeData();
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                songArrayList = (ArrayList<Song>) response.body();
                ArrayList<Song> hotSongArrayList = new ArrayList<>();
                for (int i = 0; i < 5 ; i++) {
                    hotSongArrayList.add(songArrayList.get(i));
                }
                Log.d("Get OK", hotSongArrayList.get(0).getName());
                hotSongAdapter = new HotSongAdapter(getActivity(), hotSongArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerViewHotSong.setLayoutManager(linearLayoutManager);
                recyclerViewHotSong.setAdapter(hotSongAdapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}
