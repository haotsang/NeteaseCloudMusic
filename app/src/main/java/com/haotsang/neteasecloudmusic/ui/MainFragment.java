package com.haotsang.neteasecloudmusic.ui;

import android.os.Bundle;

import com.haotsang.neteasecloudmusic.R;
import com.haotsang.neteasecloudmusic.base.BaseFragment;
import com.haotsang.neteasecloudmusic.databinding.MainFragmentBinding;

public class MainFragment extends BaseFragment<MainFragmentBinding> {

    @Override
    protected MainFragmentBinding getViewBinding() {
        return MainFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {

    }

    private void switchFragment() {

    }
}
