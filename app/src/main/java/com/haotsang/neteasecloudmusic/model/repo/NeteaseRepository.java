package com.haotsang.neteasecloudmusic.model.repo;

import com.haotsang.neteasecloudmusic.model.core.StatusData;
import com.haotsang.neteasecloudmusic.model.entity.banner.Banner;
import com.haotsang.neteasecloudmusic.model.entity.login.QrcodeImage;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadio;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadioResponse;

import java.util.List;

import io.reactivex.Observable;

public class NeteaseRepository {

    public static final String TAG = NeteaseRepository.class.getName();
    private volatile static NeteaseRepository instance = null;

    private NeteaseRepository() {
    }

    public static NeteaseRepository getInstance() {
        if (instance == null) {
            synchronized (NeteaseRepository.class) {
                if (instance == null) {
                    instance = new NeteaseRepository();
                }
            }
        }
        return instance;
    }


    /**
     * 电台推荐
     * @return {@link Observable}
     */
    public Observable<StatusData<List<RecommendRadio>>> getRecommendRadio() {
        return NeteaseRemoteDataSource.getInstance().getRecommendRadio(10);
    }

    public Observable<StatusData<QrcodeImage>> generateQrKeyAndCode() {
        return NeteaseRemoteDataSource
                .getInstance().generateQrKeyAndCode();
    }

    public Observable<StatusData<List<Banner>>> getBanner() {
        return NeteaseRemoteDataSource
                .getInstance().getBanner();
    }
}
