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

import java.util.ArrayList;

public class ListSongAdapter extends RecyclerView.Adapter<ListSongAdapter.ViewHolder> {
    Context context;
    ArrayList<Song> songArrayList;

    public ListSongAdapter(Context context, ArrayList<Song> songArrayList) {
        this.context = context;
        this.songArrayList = songArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_list_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songArrayList.get(position);
        holder.txtSingerName.setText(song.getSinger());
        holder.txtSongName.setText(song.getName());
        holder.txtIndex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtIndex, txtSingerName, txtSongName;
        ImageView imgLikeSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSingerName = itemView.findViewById(R.id.textViewSingerName);
            txtSongName = itemView.findViewById(R.id.textViewSongName);
            txtIndex = itemView.findViewById(R.id.textViewListIndex);
            imgLikeSong = itemView.findViewById(R.id.imageViewListSongLikeBtn);
        }
    }
}
