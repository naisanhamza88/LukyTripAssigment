package com.clickit.luckytripassingment.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Hamza Abdullah on 1/29/2020.
 */
@Entity(tableName = "SelectedData")
data class SelectedData(

        @SerializedName("ID")
        @Expose
        @ColumnInfo(name = "ID")
        @PrimaryKey(autoGenerate = true)
        var ID: Int? = 0,

        @SerializedName("roomName")
        @ColumnInfo(name = "roomName")
        var roomName: String? = "",

        @SerializedName("roomPrice")
        @ColumnInfo(name = "roomPrice")
        var roomPrice: String? = "",

        @SerializedName("bedConfig")
        @ColumnInfo(name = "bedConfig")
        var bedConfig: String? = ""

)
