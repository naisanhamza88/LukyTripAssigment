package com.clickit.luckytripassingment.ui.room_picker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.clickit.luckytripassingment.BR;
import com.clickit.luckytripassingment.R;
import com.clickit.luckytripassingment.base.BaseActivity;
import com.clickit.luckytripassingment.databinding.ActivityRoomPickerBinding;
import com.clickit.luckytripassingment.util.LoadingView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class RoomPickerActivity extends BaseActivity<ActivityRoomPickerBinding, RoomPickerViewModel> {

    @Inject
    RoomPickerViewModel mViewModel;

    LoadingView loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding = getViewDataBinding();
        loadingView = new LoadingView(this);
        initial();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_room_picker;
    }

    @Override
    public RoomPickerViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void initial() {
        binding.toolBar.toolbarTitle.setText(getString(R.string.rooms));
        mViewModel = new RoomPickerViewModel(this);
        mViewModel.loader.observe(this, (Observer<Boolean>) loader -> {
            if (loader) {
                loadingView.show();
            } else {
                loadingView.dismiss();
            }
        });

        binding.roomRecycler.setLayoutManager(new LinearLayoutManager(this));

        mViewModel.roomAdapter.observe(this, binding.roomRecycler::setAdapter);

        binding.toolBar.backIcon.setOnClickListener(v -> onBackPressed());
    }

}