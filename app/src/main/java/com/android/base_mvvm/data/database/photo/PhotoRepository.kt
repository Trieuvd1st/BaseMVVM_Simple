package com.android.base_mvvm.data.database.photo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val photoDao: PhotoDao) {

    fun getAll() = photoDao.getAll().flowOn(Dispatchers.IO)

    suspend fun findById(id: Int) = photoDao.findById(id)

    suspend fun insertAll(photo: PhotoEntity) = photoDao.insertAll(photo)

    suspend fun delete(photo: PhotoEntity) = photoDao.delete(photo)
}