package com.haotsang.neteasecloudmusic.ui.login;

import android.os.Bundle;
import android.widget.Toast;

import com.haotsang.neteasecloudmusic.base.BaseFragment;
import com.haotsang.neteasecloudmusic.databinding.QrLoginFragmentBinding;
import com.haotsang.neteasecloudmusic.model.entity.login.QrcodeImage;
import com.haotsang.neteasecloudmusic.model.entity.radio.recommend.RecommendRadio;
import com.haotsang.neteasecloudmusic.model.repo.NeteaseRepository;
import com.haotsang.neteasecloudmusic.utils.ImageUtils;
import com.haotsang.neteasecloudmusic.utils.LogUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginWithQrcodeFragment extends BaseFragment<QrLoginFragmentBinding> {
    @Override
    protected QrLoginFragmentBinding getViewBinding() {
        return QrLoginFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        NeteaseRepository.getInstance()
                .generateQrKeyAndCode()
                .doOnSubscribe(subscription -> System.out.println("RecommendRadioFragment.requestData"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(listStatusData -> {
                    QrcodeImage data = listStatusData.getData();
                    if (data != null) {
                        mBinding.ivQrcode.setImageBitmap(ImageUtils.stringToBitmap(data.getQrimg()));
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
