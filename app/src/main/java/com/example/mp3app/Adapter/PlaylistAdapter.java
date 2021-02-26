package com.example.mp3app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mp3app.Model.Playlist;
import com.example.mp3app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {

    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {

        super(context, resource, objects);
    }

    class ViewHolder {
        TextView txtNamePlaylist;
        ImageView imgBackground, imgPlaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_playlist, null);
            viewHolder.txtNamePlaylist = convertView.findViewById(R.id.textviewNamePlaylist);
            viewHolder.imgPlaylist = convertView.findViewById(R.id.imageviewPlaylist);
            viewHolder.imgBackground = convertView.findViewById(R.id.imageviewBackgroundPlaylist);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getBackGround()).into(viewHolder.imgBackground);
        if (playlist.getIcon() == null){
            viewHolder.imgPlaylist.setImageResource(R.drawable.dvd);
        } else {
            Picasso.with(getContext()).load(playlist.getIcon()).into(viewHolder.imgPlaylist);
        }
        viewHolder.txtNamePlaylist.setText(playlist.getName());
        return convertView;
    }
}
