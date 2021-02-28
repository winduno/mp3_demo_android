package com.example.mp3app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mp3app.Adapter.ListSongAdapter;
import com.example.mp3app.Model.Banner;
import com.example.mp3app.Model.Song;
import com.example.mp3app.R;
import com.example.mp3app.Service.APIService;
import com.example.mp3app.Service.DataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSongActivity extends AppCompatActivity {

    Banner banner;
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewSongList;
    FloatingActionButton floatingActionButton;
    ImageView imgListSong;
    ArrayList<Song> songArrayList = new ArrayList<>();
    ListSongAdapter listSongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        DataIntent();
        findView();
        init();
        if (banner != null && !banner.getContent().equals("")){
            getDataBanner(banner.getSong().getId());
            setValueInView(banner, banner.getSong().getImage());
        }
    }

    private void setValueInView(Banner inputBanner, String image) {
        collapsingToolbarLayout.setTitle(inputBanner.getContent());
        try{
            URL url = new URL(inputBanner.getImage());
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(image).into(imgListSong);
    }

    private void getDataBanner(Integer idSong) {
        DataService dataService = APIService.getService();
        Call<Song> callback = dataService.getSongById(idSong);
        callback.enqueue(new Callback<Song>() {
            @Override
            public void onResponse(Call<Song> call, Response<Song> response) {
                songArrayList.add(response.body());
                listSongAdapter = new ListSongAdapter(ListSongActivity.this,songArrayList);
                recyclerViewSongList.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewSongList.setAdapter(listSongAdapter);
            }

            @Override
            public void onFailure(Call<Song> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void findView() {
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        toolbar = findViewById(R.id.toolbarList);
        recyclerViewSongList = findViewById(R.id.recyclerviewSongList);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        imgListSong = findViewById(R.id.imageViewListSong);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("banner")){
                banner = (Banner) intent.getSerializableExtra("banner");
            }
        }
    }
}