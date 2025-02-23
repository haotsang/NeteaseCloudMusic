package com.haotsang.neteasecloudmusic.model.api;

import com.haotsang.neteasecloudmusic.model.core.ApiResponse;
import com.haotsang.neteasecloudmusic.model.entity.banner.Banner;
import com.haotsang.neteasecloudmusic.model.entity.banner.BaseBanner;
import com.haotsang.neteasecloudmusic.model.entity.login.QrcodeImage;
import com.haotsang.neteasecloudmusic.model.entity.login.QrcodeKey;
import com.haotsang.neteasecloudmusic.model.entity.login.QrcodeStatus;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadio;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadioResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MusicApi {

    /**
     * 二维码 key 生成接口
     *
     * @param timestamp 时间戳,防止缓存
     */
    @GET("login/qr/key")
    Observable<ApiResponse<QrcodeKey>> generateQrKey(@Query("timestamp") String timestamp);

    /**
     * 二维码生成接口
     *
     * @param key 必选参数: key,由 {@link #generateQrKey(String)} 接口生成
     * @param qrimg 可选参数,传入后会额外返回二维码图片 base64 编码
     * @param timestamp 时间戳,防止缓存
     */
    @GET("login/qr/create")
    Observable<ApiResponse<QrcodeImage>> generateQrCode(@QueryMap Map<String, String> map);

    /**
     * 二维码检测扫码状态接口
     *
     * @param key 必选参数: key,由 {@link #generateQrKey(String)} 接口生成
     */
    @GET("login/qr/check")
    Observable<QrcodeStatus> checkingQrCode(@Query("key") String key, @Query("timestamp") String timestamp);


    /**
     * 电台个性推荐
     *
     * @param limit : 返回数量,默认为 6,总条数最多 6 条
     * @return {@link Observable}
     */
    @GET("dj/personalize/recommend")
    Observable<RecommendRadioResponse<RecommendRadio>> getRecommendRadio(@Query("limit") int limit);
//
//    /**
//     * 热门电台
//     *
//     * @param limit  : 返回数量 , 默认为 30
//     * @param offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
//     * @return {@link Observable}
//     */
//    @GET("dj/hot")
//    Observable<> getRadio()


    @GET("banner")
    Observable<BaseBanner<Banner>> getBanner(@Query("type") int type);
}
