package com.clickit.luckytripassingment.ui.main_page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.clickit.luckytripassingment.BR;
import com.clickit.luckytripassingment.R;
import com.clickit.luckytripassingment.base.BaseActivity;
import com.clickit.luckytripassingment.databinding.ActivityMainBinding;
import com.clickit.luckytripassingment.ui.room_picker.RoomPickerActivity;
import com.clickit.luckytripassingment.util.LoadingView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPageViewModel> {

    @Inject
    MainPageViewModel mViewModel;

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
        return R.layout.activity_main;
    }

    @Override
    public MainPageViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void initial() {
        mViewModel = new MainPageViewModel(this);
        binding.toolBar.backIcon.setVisibility(View.GONE);
        binding.toolBar.toolbarTitle.setText(getString(R.string.home));
        binding.cardView.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RoomPickerActivity.class)));
        loadingView = new LoadingView(this);

        binding.selectedDataRecycler.setLayoutManager(new LinearLayoutManager(this));

        mViewModel.mainAdapter.observe(this, binding.selectedDataRecycler::setAdapter);
    }
}