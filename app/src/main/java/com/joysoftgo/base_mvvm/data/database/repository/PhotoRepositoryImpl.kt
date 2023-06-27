package com.joysoftgo.base_mvvm.data.database.repository

import com.joysoftgo.base_mvvm.data.database.dao.PhotoDao
import com.joysoftgo.base_mvvm.data.database.entities.PhotoEntity
import com.joysoftgo.base_mvvm.domain.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(private val photoDao: PhotoDao): PhotoRepository {

    override fun getAll() = photoDao.getAll().flowOn(Dispatchers.IO)

    override suspend fun findById(id: Int) = photoDao.findById(id)

    override suspend fun insertAll(photo: PhotoEntity) = photoDao.insertAll(photo)

    override suspend fun delete(photo: PhotoEntity) = photoDao.delete(photo)
}