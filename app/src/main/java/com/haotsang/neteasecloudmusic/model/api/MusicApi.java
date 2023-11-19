package com.haotsang.neteasecloudmusic.model.api;

import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadio;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadioResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MusicApi {

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

}
