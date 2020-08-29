package com.clickit.luckytripassingment.adpter;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.clickit.luckytripassingment.R;
import com.clickit.luckytripassingment.dataBase.SelectedData;
import com.clickit.luckytripassingment.databinding.MainItemBinding;
import com.clickit.luckytripassingment.databinding.RoomItemBinding;
import com.clickit.luckytripassingment.helper.DataBaseHelper;
import com.clickit.luckytripassingment.model.Rooms;
import com.clickit.luckytripassingment.ui.main_page.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    AppCompatActivity activity;
    ArrayList<SelectedData> mDataSet;

    public MainAdapter(AppCompatActivity mActivity) {
        activity = mActivity;
        mDataSet = new ArrayList<>();
    }

    public void updateAdapter(ArrayList<SelectedData> list) {
        mDataSet.clear();
        mDataSet.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.main_item, parent, false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bind(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        MainItemBinding rootView;
        MainItemViewModel viewModel;

        MainViewHolder(MainItemBinding v) {
            super(v.getRoot());
            rootView = v;
            viewModel = new MainItemViewModel();

        }

        void bind(SelectedData data) {
            rootView.setViewModel(viewModel);
            viewModel.bind(data);
        }
    }
}