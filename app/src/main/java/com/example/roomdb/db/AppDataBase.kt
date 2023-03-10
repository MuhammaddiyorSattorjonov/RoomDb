package com.example.roomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb.models.MyPerson


@Database(entities = [MyPerson::class], version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun myDao():MyPersonDao

    companion object{
        private var instance:AppDataBase? = null

        @Synchronized
        fun getInstance(context:Context):AppDataBase{
            if (instance==null){
                instance = Room.databaseBuilder(context,AppDataBase::class.java,"Hello")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }

}