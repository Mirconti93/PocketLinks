package com.mircontapp.sportalbum.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LinkDao {

    @Insert
    fun insert(vararg link: Link)

    @Insert
    fun insertAll(links: List<Link>)

    @Delete
    fun delete(link: Link)

    @Query("select * from link")
    fun getAll(): List<Link>

    @Update
    fun update(team: Link)

}