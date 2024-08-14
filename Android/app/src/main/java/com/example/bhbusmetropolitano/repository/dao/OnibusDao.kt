package com.example.bhbusmetropolitano.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bhbusmetropolitano.model.OnibusModel

@Dao
interface OnibusDao{
    @Insert
    fun insertOnibus(onibus: OnibusModel) : Long

    @Update
    fun updateOnibus(onibus: OnibusModel) : Int

    @Delete
    fun deleteOnibus(onibus: OnibusModel) : Int

    @Query("SELECT * FROM Onibus WHERE id_onibus = :id")
    fun get(id: Int): OnibusModel

    @Query("SELECT * FROM onibus")
    fun getAll(): List<OnibusModel>
}