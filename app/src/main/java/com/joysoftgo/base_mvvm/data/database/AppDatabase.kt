package com.joysoftgo.base_mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joysoftgo.base_mvvm.data.database.dao.PhotoDao
import com.joysoftgo.base_mvvm.data.database.entities.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1)
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}
