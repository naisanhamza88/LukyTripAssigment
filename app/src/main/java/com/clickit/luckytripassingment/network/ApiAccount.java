package com.clickit.luckytripassingment.network;

import com.clickit.luckytripassingment.model.RoomResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiAccount {


    @GET("rooms/")
    Observable<RoomResponse> getRooms(@Query("language_code") String languageCode);

}
