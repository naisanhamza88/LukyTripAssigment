package com.clickit.luckytripassingment.adpter;

import androidx.lifecycle.MutableLiveData;

import com.clickit.luckytripassingment.base.BaseViewModel;
import com.clickit.luckytripassingment.dataBase.SelectedData;

public class MainItemViewModel extends BaseViewModel {

    public MutableLiveData<String> roomName = new MutableLiveData<>();
    public MutableLiveData<String> roomPriceWithCurrency = new MutableLiveData<>();
    public MutableLiveData<String> roomBedConfig = new MutableLiveData<>();

    public void bind(SelectedData data) {
        roomName.setValue(data.getRoomName());
        roomPriceWithCurrency.setValue(data.getRoomPrice());
        roomBedConfig.setValue(data.getBedConfig());
    }


}
