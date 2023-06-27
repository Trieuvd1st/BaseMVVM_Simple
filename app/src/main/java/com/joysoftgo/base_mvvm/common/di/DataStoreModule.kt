package com.joysoftgo.base_mvvm.common.di

import com.joysoftgo.base_mvvm.domain.repository.DataStoreRepository
import com.joysoftgo.base_mvvm.data.datastore.DataStoreManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {
    @Binds
    abstract fun provideDataStoreHelper(dataStoreManager: DataStoreManager): DataStoreRepository
}
