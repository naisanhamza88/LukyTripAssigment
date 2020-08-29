package com.clickit.luckytripassingment.ui.room_picker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.clickit.luckytripassingment.adpter.RoomAdapter;
import com.clickit.luckytripassingment.base.BaseActivity;
import com.clickit.luckytripassingment.base.BaseViewModel;
import com.clickit.luckytripassingment.model.Rooms;

import java.util.ArrayList;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RoomPickerViewModel extends BaseViewModel {

    MutableLiveData<RoomAdapter> roomAdapter= new MutableLiveData<>();
    MutableLiveData<Boolean> loader= new MutableLiveData<>();
    MutableLiveData<Boolean> showError= new MutableLiveData<>();

    RoomPickerViewModel(AppCompatActivity activity) {
        roomAdapter.setValue(new RoomAdapter(activity));
        getData();
    }

    private void getData() {
        subscription = apiAccount.getRooms("en").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> loader.setValue(true))
                .doOnTerminate(() -> loader.setValue(false))
                .subscribe(data -> {
                    loader.setValue(false);
                   roomAdapter.getValue().updateAdapter((ArrayList<Rooms>) data.getRooms());
                }, error -> {
                    loader.setValue(false);
                    showError.setValue(true);
                });

    }

}
