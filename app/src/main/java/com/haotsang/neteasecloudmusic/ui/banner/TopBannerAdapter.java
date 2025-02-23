package com.haotsang.neteasecloudmusic.ui.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.haotsang.neteasecloudmusic.R;
import com.haotsang.neteasecloudmusic.model.entity.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class TopBannerAdapter extends BannerAdapter<Banner, TopBannerAdapter.ImageHolder> {
    public TopBannerAdapter(List<Banner> datas) {
        super(datas);
    }

    @Override
    public TopBannerAdapter.ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindView(TopBannerAdapter.ImageHolder holder, Banner data, int position, int size) {
        Glide.with(holder.itemView)
                .load(data.getPic())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }

    public static class ImageHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_banner);
        }
    }
}
