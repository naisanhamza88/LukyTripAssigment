package com.clickit.luckytripassingment.ui.main_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.clickit.luckytripassingment.adpter.MainAdapter;
import com.clickit.luckytripassingment.base.BaseViewModel;
import com.clickit.luckytripassingment.dataBase.SelectedData;
import com.clickit.luckytripassingment.helper.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainPageViewModel extends BaseViewModel {

    MutableLiveData<MainAdapter> mainAdapter = new MutableLiveData<>();

    MainPageViewModel(AppCompatActivity activity) {
        List<SelectedData> list = DataBaseHelper.Companion.init(activity).getRoomDatabase().settingsInteract().getData();
        mainAdapter.setValue(new MainAdapter(activity));
        Objects.requireNonNull(mainAdapter.getValue()).updateAdapter((ArrayList<SelectedData>) list);
    }
}
