package com.joysoftgo.base_mvvm.domain.repository

import com.joysoftgo.base_mvvm.data.database.entities.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    fun getAll(): Flow<List<PhotoEntity>>

    suspend fun findById(id: Int): PhotoEntity

    suspend fun insertAll(photo: PhotoEntity)

    suspend fun delete(photo: PhotoEntity)

}