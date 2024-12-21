package com.mircontapp.sportalbum.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "association")
class Association (
    @PrimaryKey val id: String,
    val link: String,
    val category: String,
)


