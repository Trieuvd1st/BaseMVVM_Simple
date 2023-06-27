package com.joysoftgo.base_mvvm.common.di

import com.joysoftgo.base_mvvm.data.database.dao.PhotoDao
import com.joysoftgo.base_mvvm.data.database.repository.PhotoRepositoryImpl
import com.joysoftgo.base_mvvm.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePhotoRepository(photoDao: PhotoDao): PhotoRepository {
        return PhotoRepositoryImpl(photoDao)
    }
}