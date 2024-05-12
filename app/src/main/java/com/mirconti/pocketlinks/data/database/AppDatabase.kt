package com.mircontapp.sportalbum.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Category::class, Link::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun linkDao(): LinkDao
    abstract fun categoryDao(): CategoryDao
    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context) : AppDatabase? {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "albumdb.sqlite"
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
