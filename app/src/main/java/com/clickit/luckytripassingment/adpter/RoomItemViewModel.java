package com.clickit.luckytripassingment.adpter;

import androidx.lifecycle.MutableLiveData;

import com.clickit.luckytripassingment.base.BaseViewModel;
import com.clickit.luckytripassingment.model.Rooms;

public class RoomItemViewModel extends BaseViewModel {

    public MutableLiveData<String> roomName = new MutableLiveData<>();
    public MutableLiveData<String> roomDescription = new MutableLiveData<>();
    public MutableLiveData<String> roomMaxOccupancy = new MutableLiveData<>();
    public MutableLiveData<String> roomPriceWithCurrency = new MutableLiveData<>();
    public MutableLiveData<String> roomBedConfig = new MutableLiveData<>();
    public MutableLiveData<Boolean> descriptionVisibility = new MutableLiveData<>();

    public void bind(Rooms data) {
        roomName.setValue(data.getName());
        roomDescription.setValue(data.getRoomDescription());
        roomMaxOccupancy.setValue(String.valueOf(data.getMaxOccupancy()));
        roomPriceWithCurrency.setValue(data.getPrice().getPriceValue() + data.getPrice().getCurrency());
        if (data.getRoomDescription().isEmpty()) {
            descriptionVisibility.setValue(false);
        } else {
            descriptionVisibility.setValue(true);
        }
        StringBuilder bdConfig = new StringBuilder();

        for (int i = 0; i < data.getBedConfigurations().size(); i++) {
            bdConfig.append(data.getBedConfigurations().get(i).getName())
                    .append(": ").append(data.getBedConfigurations().get(i).getCount());
        }
        roomBedConfig.setValue(String.valueOf(bdConfig));
    }


}
