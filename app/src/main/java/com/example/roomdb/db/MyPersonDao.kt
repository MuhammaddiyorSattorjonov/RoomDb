package com.example.roomdb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdb.models.MyPerson

@Dao
interface MyPersonDao {

    @Insert
    fun addPerson(myPerson: MyPerson)

    @Query("select * from MyPerson")
    fun getAllPerson():List<MyPerson>

}