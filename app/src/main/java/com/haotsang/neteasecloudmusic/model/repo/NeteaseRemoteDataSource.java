package com.haotsang.neteasecloudmusic.model.repo;

import com.haotsang.neteasecloudmusic.model.api.MusicApi;
import com.haotsang.neteasecloudmusic.model.core.ApiResponse;
import com.haotsang.neteasecloudmusic.model.core.StatusData;
import com.haotsang.neteasecloudmusic.model.entity.banner.Banner;
import com.haotsang.neteasecloudmusic.model.entity.banner.BaseBanner;
import com.haotsang.neteasecloudmusic.model.entity.login.QrcodeImage;
import com.haotsang.neteasecloudmusic.model.entity.login.QrcodeKey;
import com.haotsang.neteasecloudmusic.model.entity.login.QrcodeStatus;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadio;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadioResponse;
import com.haotsang.neteasecloudmusic.utils.RetrofitUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class NeteaseRemoteDataSource {
    private volatile static NeteaseRemoteDataSource instance = null;
    private static final String BASE_URL = "http://47.116.41.39:3000/";

    private final MusicApi musicApi;
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


    public Observable<StatusData<QrcodeKey>> generateQrKey() {
        return getApi()
                .generateQrKey(String.valueOf(System.currentTimeMillis()))
                .flatMap((Function<ApiResponse<QrcodeKey>, Observable<StatusData<QrcodeKey>>>) response -> {
                    if (response.isSuccess()) {
                        return Observable.just(StatusData.content(response.getResult()));
                    }

                    return Observable.just(StatusData.empty());
                }).subscribeOn(Schedulers.io());
    }


    public Observable<StatusData<QrcodeImage>> generateCode(String key) {
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("qrimg", "1");
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));

        return getApi()
                .generateQrCode(map)
                .flatMap((Function<ApiResponse<QrcodeImage>, Observable<StatusData<QrcodeImage>>>) response -> {
                    if (response.isSuccess()) {
                        return Observable.just(StatusData.content(response.getResult()));
                    }
                    return Observable.just(StatusData.empty());
                }).subscribeOn(Schedulers.io());
    }

    public Observable<StatusData<QrcodeStatus>> checkingQrCode(String key) {
        return getApi()
                .checkingQrCode(key, String.valueOf(System.currentTimeMillis()))
                .flatMap((Function<QrcodeStatus, Observable<StatusData<QrcodeStatus>>>) response -> {
                    if (response.isSuccess()) {
                        return Observable.just(StatusData.content(response));
                    }
                    return Observable.just(StatusData.empty());
                }).subscribeOn(Schedulers.io());
    }

    public Observable<StatusData<QrcodeImage>> generateQrKeyAndCode() {
        return getApi()
                .generateQrKey(String.valueOf(System.currentTimeMillis()))
                .flatMap((Function<ApiResponse<QrcodeKey>, Observable<StatusData<QrcodeImage>>>) responseKey -> {
                    if (responseKey.isSuccess()) {
                        String key = String.valueOf(System.currentTimeMillis());
                        Map<String, String> map = new HashMap<>();
                        map.put("key", key);
                        map.put("qrimg", "1");
                        map.put("timestamp", String.valueOf(System.currentTimeMillis()));

                        return getApi().generateQrCode(map)
                                .flatMap((Function<ApiResponse<QrcodeImage>, Observable<StatusData<QrcodeImage>>>) responseCode -> {
                                    if (responseCode.isSuccess()) {

                                        return Observable.just(StatusData.content(responseCode.getResult()));
                                    }
                                    return Observable.just(StatusData.empty());
                                });
                    }
                    return Observable.just(StatusData.empty());
                })
                .subscribeOn(Schedulers.io());
    }




    /**
     * 电台推荐
     * @param limit
     * @return
     */
    public Observable<StatusData<List<RecommendRadio>>> getRecommendRadio(int limit) {
        return getApi()
                .getRecommendRadio(limit)
                .flatMap((Function<RecommendRadioResponse<RecommendRadio>, Observable<StatusData<List<RecommendRadio>>>>) response -> {
                    if (response.isSuccess()) {
                        return Observable.just(StatusData.content(response.getData()));
                    }

                    return Observable.just(StatusData.empty());
                }).subscribeOn(Schedulers.io());
    }


    public Observable<StatusData<List<Banner>>> getBanner() {
        return getApi()
                .getBanner(1)
                .flatMap((Function<BaseBanner<Banner>, Observable<StatusData<List<Banner>>>>) response -> {
                    if (response.isSuccess()) {
                        return Observable.just(StatusData.content(response.getBanners()));
                    }

                    return Observable.just(StatusData.empty());
                });
    }


}
