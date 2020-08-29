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
import com.clickit.luckytripassingment.databinding.RoomItemBinding;
import com.clickit.luckytripassingment.helper.DataBaseHelper;
import com.clickit.luckytripassingment.model.Rooms;
import com.clickit.luckytripassingment.ui.main_page.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    AppCompatActivity activity;
    ArrayList<Rooms> mDataSet;

    public RoomAdapter(AppCompatActivity mActivity) {
        activity = mActivity;
        mDataSet = new ArrayList<>();
    }

    public void updateAdapter(ArrayList<Rooms> list) {
        mDataSet.clear();
        mDataSet.addAll(list);
        Collections.sort(mDataSet, (Comparator<Rooms>) (o1, o2) -> {
            Integer MaxOccupancy1 = o1.getMaxOccupancy();
            Integer MaxOccupancy2 = o2.getMaxOccupancy();
            return MaxOccupancy1.compareTo(MaxOccupancy2);
        });
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RoomItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.room_item, parent, false);
        return new RoomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.bind(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        RoomItemBinding rootView;
        RoomItemViewModel viewModel;

        RoomViewHolder(RoomItemBinding v) {
            super(v.getRoot());
            rootView = v;
            viewModel = new RoomItemViewModel();
        }

        void bind(Rooms data) {
            rootView.setViewModel(viewModel);
            viewModel.bind(data);

            rootView.roomContainer.setOnClickListener(v -> showLangDialog(data));
        }

        private void showLangDialog(Rooms data) {

            Dialog dialog = new Dialog(activity, R.style.DialogSlideAnimation);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            View dialogView =
                    View.inflate(activity, R.layout.dialog, null);

            dialog.setContentView(dialogView);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(true);
            ImageView room_Image = dialogView.findViewById(R.id.room_Image);
            TextView room_name = dialogView.findViewById(R.id.room_name);
            TextView room_price = dialogView.findViewById(R.id.room_price);
            TextView select = dialogView.findViewById(R.id.bt_join);
            TextView cancel = dialogView.findViewById(R.id.bt_decline);
            room_name.setText(data.getName());
            room_price.setText(data.getPrice().getPriceValue() + data.getPrice().getCurrency());
            Picasso.get().load(data.getPhotos().get(0)).into(room_Image);

            select.setOnClickListener(v -> {
                selectItem(data);
                dialog.dismiss();
            });

            cancel.setOnClickListener(v -> dialog.dismiss());
            dialog.show();

        }

        private void selectItem(Rooms data) {
            SelectedData selectedData = new SelectedData();
            selectedData.setRoomName(data.getName());
            StringBuilder bdConfig = new StringBuilder();

            for (int i = 0; i < data.getBedConfigurations().size(); i++) {
                bdConfig.append(data.getBedConfigurations().get(i).getName())
                        .append(": ").append(data.getBedConfigurations().get(i).getCount());
            }
            selectedData.setBedConfig(String.valueOf(bdConfig));
            selectedData.setRoomPrice(data.getPrice().getPriceValue() + data.getPrice().getCurrency());
            if (DataBaseHelper.Companion.init(activity).getRoomDatabase().settingsInteract().checkData()>0){
                DataBaseHelper.Companion.init(activity).getRoomDatabase().settingsInteract().checkData();
            }
            DataBaseHelper.Companion.init(activity).getRoomDatabase().settingsInteract().insertData(selectedData);
            activity.startActivity(new Intent(activity, MainActivity.class));
        }
    }
}