package com.joysoftgo.base_mvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.joysoftgo.base_mvvm.data.database.entities.PhotoEntity.Companion.TABLE_PHOTO

@Entity(tableName = TABLE_PHOTO)
class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "type")
    val type: Int
) {
    companion object {
        const val TABLE_PHOTO = "TABLE_PHOTO"
    }
}