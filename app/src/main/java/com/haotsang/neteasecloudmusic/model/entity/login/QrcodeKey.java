package com.haotsang.neteasecloudmusic.model.entity.login;

import com.google.gson.annotations.SerializedName;

public class QrcodeKey {

    @SerializedName("code")
    private int code;
    @SerializedName("unikey")
    private String uniKey;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUniKey() {
        return uniKey;
    }

    public void setUniKey(String uniKey) {
        this.uniKey = uniKey;
    }
}
