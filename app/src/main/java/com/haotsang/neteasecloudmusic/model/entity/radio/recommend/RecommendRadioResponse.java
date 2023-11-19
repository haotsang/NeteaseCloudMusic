package com.haotsang.neteasecloudmusic.model.entity.radio.recommend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecommendRadioResponse<T> {

    @SerializedName("data")
    private List<T> data;

    @SerializedName("code")
    private Integer code;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return code == 200 && data != null;
    }
}
