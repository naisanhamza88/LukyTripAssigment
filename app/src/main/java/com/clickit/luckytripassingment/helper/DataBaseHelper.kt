package com.clickit.luckytripassingment.helper

import android.content.Context
import androidx.room.Room
import com.nafith.nafithoman.dataBase.DataBase
import javax.inject.Singleton

/**
 * Created by Hamza Abdullah on 1/28/2020.
 */

@Singleton
class DataBaseHelper private constructor() {

    val roomDatabase: DataBase

    private object Holder {
        val INSTANCE = DataBaseHelper()
    }


    init {
        roomDatabase = Room.databaseBuilder(
            appContext!!,
            DataBase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .addMigrations(DataBase.MIGRATION_1_30)
            .build()
    }


    companion object {
        private const val DATABASE_NAME = "LukyDataBase.sqlite"
        private var appContext: Context? = null
        fun init(context: Context): DataBaseHelper {
            appContext = context
            return Holder.INSTANCE
        }
    }
}