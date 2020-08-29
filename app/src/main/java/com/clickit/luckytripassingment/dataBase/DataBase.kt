package com.nafith.nafithoman.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.clickit.luckytripassingment.dataBase.SelectedData
import com.clickit.luckytripassingment.dataBase.UserSelectedDataDao

/**
 * Created by Hamza Abdullah on 1/28/2020.
 */

@Database(
        entities = [SelectedData::class],
        version = 1
)


abstract class DataBase : RoomDatabase() {

    abstract fun settingsInteract(): UserSelectedDataDao

    companion object {
        @JvmField
        val MIGRATION_1_30: Migration = object : Migration(1, 30) {
            override fun migrate(database: SupportSQLiteDatabase) {
            }
        }

    }


}