package com.mircontapp.sportalbum.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CategoryDao {

    @Insert
    fun insert(vararg category: Category)

    @Insert
    fun insertAll(categorys: List<Category>)

    @Delete
    fun delete(category: Category)

    @Query("select * from category")
    fun getAll(): List<Category>

    @Update
    fun update(category: Category)

}