package com.haotsang.neteasecloudmusic.ui.banner;

import android.os.Bundle;

import com.haotsang.neteasecloudmusic.base.BaseFragment;
import com.haotsang.neteasecloudmusic.databinding.BannerFragmentBinding;
import com.haotsang.neteasecloudmusic.model.repo.NeteaseRepository;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BannerFragment extends BaseFragment<BannerFragmentBinding> {

    private TopBannerAdapter bannerAdapter;
    @Override
    protected BannerFragmentBinding getViewBinding() {
        return BannerFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        bannerAdapter = new TopBannerAdapter(new ArrayList<>());
        mBinding.bannerView.setAdapter(bannerAdapter)
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(requireContext()))
                .start();

        update();
    }

    private void update() {


        NeteaseRepository
                .getInstance()
                .getBanner()
                .doOnSubscribe(subscription -> System.out.println("RecommendRadioFragment.requestData"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    bannerAdapter.setDatas(result.getData());

                });
    }
}
