package com.haotsang.neteasecloudmusic.model.entity.radio.djRadios;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DjRadiosResponse<T> {

    @SerializedName("djRadios")
    private List<T> djRadios;
    @SerializedName("hasMore")
    private Boolean hasMore;
    @SerializedName("code")
    private Integer code;



}
