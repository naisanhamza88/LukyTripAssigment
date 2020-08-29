package com.clickit.luckytripassingment.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Hamza Abdullah on 1/29/2020.
 */
@Dao
interface UserSelectedDataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(model: SelectedData)

    @Query("SELECT COUNT(*) FROM SelectedData")
    fun checkData(): Int

    @Query("SELECT * FROM SelectedData")
    fun getData(): List<SelectedData>

    @Query("DELETE FROM SelectedData")
    fun clearTable()
}