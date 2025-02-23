package com.haotsang.neteasecloudmusic.model.entity.banner;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseBanner<T> {

    @SerializedName("banners")
    private List<T> banners;

    @SerializedName("code")
    private int code;

    public List<T> getBanners() {
        return banners;
    }

    public void setBanners(List<T> banners) {
        this.banners = banners;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return code == 200 && banners != null;
    }
}
