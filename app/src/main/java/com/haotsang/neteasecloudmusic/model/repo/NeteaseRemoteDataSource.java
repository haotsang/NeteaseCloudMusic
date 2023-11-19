package com.haotsang.neteasecloudmusic.model.repo;

import com.haotsang.neteasecloudmusic.model.api.MusicApi;
import com.haotsang.neteasecloudmusic.model.core.StatusData;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadio;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadioResponse;
import com.haotsang.neteasecloudmusic.utils.RetrofitUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class NeteaseRemoteDataSource {
    private volatile static NeteaseRemoteDataSource instance = null;
    private static final String BASE_URL = "http://47.116.41.39:3000/";

    private MusicApi musicApi;
    private NeteaseRemoteDataSource() {
        musicApi = RetrofitUtil
                .getInstance()
                .getClient(MusicApi.class, BASE_URL);
    }

    public static NeteaseRemoteDataSource getInstance() {
        if (instance == null) {
            synchronized (NeteaseRemoteDataSource.class) {
                if (instance == null) {
                    instance = new NeteaseRemoteDataSource();
                }
            }
        }
        return instance;
    }

    public MusicApi getApi() {
        return musicApi;
    }


    public Observable<StatusData<List<RecommendRadio>>> getRecommendRadio(int limit) {
        return musicApi.getRecommendRadio(limit)
                .flatMap((Function<RecommendRadioResponse<RecommendRadio>, Observable<StatusData<List<RecommendRadio>>>>) response -> {
                    if (response != null && response.isSuccess()) {
                        return Observable.just(StatusData.content(response.getData()));
                    }

                    return Observable.just(StatusData.empty());
                }).subscribeOn(Schedulers.io());
    }


}
