package com.mircontapp.sportalbum.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "association")
class Association (
    @PrimaryKey(autoGenerate = true) val id: Long  = 0,
    val link: String,
    val category: String,
)


