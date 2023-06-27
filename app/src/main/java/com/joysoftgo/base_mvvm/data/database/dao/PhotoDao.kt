package com.joysoftgo.base_mvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.joysoftgo.base_mvvm.data.database.entities.PhotoEntity
import com.joysoftgo.base_mvvm.data.database.entities.PhotoEntity.Companion.TABLE_PHOTO
import kotlinx.coroutines.flow.Flow


@Dao
interface PhotoDao {
    @Query("SELECT * FROM $TABLE_PHOTO")
    fun getAll(): Flow<List<PhotoEntity>>

    @Query("SELECT * FROM $TABLE_PHOTO WHERE id = :id")
    suspend fun findById(id: Int): PhotoEntity

    @Insert
    suspend fun insertAll(vararg photo: PhotoEntity)

    @Delete
    suspend fun delete(photo: PhotoEntity)
}