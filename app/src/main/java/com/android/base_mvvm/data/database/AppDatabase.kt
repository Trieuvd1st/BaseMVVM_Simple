package com.android.base_mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.base_mvvm.data.database.photo.PhotoDao
import com.android.base_mvvm.data.database.photo.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1)
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}
