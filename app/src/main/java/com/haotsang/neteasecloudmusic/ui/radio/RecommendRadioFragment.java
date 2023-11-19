package com.haotsang.neteasecloudmusic.ui.radio;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.haotsang.neteasecloudmusic.R;
import com.haotsang.neteasecloudmusic.base.BaseFragment;
import com.haotsang.neteasecloudmusic.databinding.RecommendRadioFragmentBinding;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadio;
import com.haotsang.neteasecloudmusic.model.repo.NeteaseRepository;
import com.haotsang.neteasecloudmusic.utils.LogUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RecommendRadioFragment extends BaseFragment<RecommendRadioFragmentBinding> {
    private BaseQuickAdapter<RecommendRadio, BaseViewHolder> adapter;

    @Override
    protected RecommendRadioFragmentBinding getViewBinding() {
        return RecommendRadioFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        adapter = new BaseQuickAdapter<>(R.layout.recommend_radio_item) {
            @Override
            protected void convert(@NonNull BaseViewHolder baseViewHolder, RecommendRadio item) {

                ImageView iv = baseViewHolder.getView(R.id.iv_cover);
                Glide.with(iv).load(item.getPicUrl()).into(iv);

                baseViewHolder.setText(R.id.tv_title, item.getRcmdText());
                baseViewHolder.setText(R.id.tv_subtitle, item.getDesc());
                baseViewHolder.setText(R.id.tv_play_count, "" + item.getSubCount());
                baseViewHolder.setText(R.id.tv_author, "" + item.getName());

            }
        };
        adapter.setOnItemClickListener((adapter, view, position) -> {

        });
        mBinding.rvList.setAdapter(adapter);
        mBinding.rvList.setLayoutManager(new LinearLayoutManager(requireContext()));

        requestData();
    }

    private void requestData() {
        NeteaseRepository.getInstance()
                .getRecommendRadio()
                .doOnSubscribe(subscription -> System.out.println("RecommendRadioFragment.requestData"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(listStatusData -> {
                    List<RecommendRadio> data = listStatusData.getData();
                    if (!data.isEmpty()) {
                        adapter.setNewInstance(data);
                        return true;
                    }

                    return false;
                }).subscribe(status -> {
                    if (status) {

                    }
                }, throwable -> {
                    LogUtils.e(throwable.toString());
                    Toast.makeText(requireContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
