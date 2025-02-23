package com.haotsang.neteasecloudmusic.model.entity.login;

import com.google.gson.annotations.SerializedName;

public class QrcodeImage {

    @SerializedName("qrurl")
    private String qrurl;

    @SerializedName("qrimg")
    private String qrimg;

    public String getQrurl() {
        return qrurl;
    }

    public void setQrurl(String qrurl) {
        this.qrurl = qrurl;
    }

    public String getQrimg() {
        return qrimg;
    }

    public void setQrimg(String qrimg) {
        this.qrimg = qrimg;
    }
}
