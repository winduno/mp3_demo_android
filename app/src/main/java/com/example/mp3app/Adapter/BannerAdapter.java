package com.example.mp3app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mp3app.Model.Banner;
import com.example.mp3app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Banner> bannerArrayList;

    public BannerAdapter(Context context, ArrayList<Banner> bannerArrayList) {
        this.context = context;
        this.bannerArrayList = bannerArrayList;
    }

    @Override
    public int getCount() {
        return bannerArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.banner_row, null);

        ImageView imgBackgroundBanner = view.findViewById(R.id.imageViewBackgroundBanner);
        ImageView imgSongBanner = view.findViewById(R.id.imageViewBanner);
        TextView txtTitleSongBanner = view.findViewById(R.id.textViewTitleBanner);
        TextView txtContent = view.findViewById(R.id.textViewContent);

        Picasso.with(context).load(bannerArrayList.get(position).getImage()).into(imgBackgroundBanner);
        Picasso.with(context).load(bannerArrayList.get(position).getSong().getImage()).into(imgSongBanner);
        txtTitleSongBanner.setText(bannerArrayList.get(position).getSong().getName());
        txtContent.setText(bannerArrayList.get(position).getContent());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
