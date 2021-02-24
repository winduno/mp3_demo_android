package com.example.mp3app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.Model.Song;
import com.example.mp3app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HotSongAdapter extends RecyclerView.Adapter<HotSongAdapter.ViewHolder>{
    Context context;
    ArrayList<Song> songArrayList;

    public HotSongAdapter(Context context, ArrayList<Song> songArrayList) {
        this.context = context;
        this.songArrayList = songArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hot_song_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songArrayList.get(position);
        holder.txtSingerName.setText(song.getSinger());
        holder.txtSongName.setText(song.getName());
        Picasso.with(context).load(song.getImage()).into(holder.imgSongImage);
    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtSongName, txtSingerName;
        ImageView imgSongImage, imgLike;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSongName = itemView.findViewById(R.id.textviewHotSongName);
            txtSingerName = itemView.findViewById(R.id.textviewHotSongSinger);
            imgSongImage = itemView.findViewById(R.id.imageViewHotSong);
            imgLike = itemView.findViewById(R.id.imageViewLike);

        }
    }
}
