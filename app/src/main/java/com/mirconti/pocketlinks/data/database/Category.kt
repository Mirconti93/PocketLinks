package com.mircontapp.sportalbum.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
class Category (
    @PrimaryKey val name: String,
    val categoryUp: String?,

)


