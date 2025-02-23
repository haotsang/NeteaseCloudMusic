package com.haotsang.neteasecloudmusic.model.entity.login;

import com.google.gson.annotations.SerializedName;

public class QrcodeStatus {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("cookie")
    private String cookie;


    public boolean isExpire() {
        return code == 800;
    }

    public boolean isWaiting() {
        return code == 801;
    }

    public boolean isBeConfirm() {
        return code == 802;
    }

    public boolean isSuccess() {
        return code == 803 ;
    }

}
