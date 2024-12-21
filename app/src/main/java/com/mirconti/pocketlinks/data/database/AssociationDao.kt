package com.mircontapp.sportalbum.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AssociationDao {

    @Insert
    fun insert(vararg association: Association)

    @Insert
    fun insertAll(associations: List<Association>)

    @Delete
    fun delete(association: Association)

    @Query("select * from association")
    fun getAll(): List<Association>

    @Update
    fun update(association: Association)

}