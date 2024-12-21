package com.mircontapp.sportalbum.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "link")
data class Link (
    @PrimaryKey val name: String,
    val url: String,
    val type: String?,
    val favourite: Boolean?
)

