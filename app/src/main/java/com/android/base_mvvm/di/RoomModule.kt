//package com.joysoftgo.base_mvvm.common.di
//
//import android.app.Application
//import androidx.room.Room
//import com.joysoftgo.base_mvvm.common.utils.DATABASE_NAME
//import com.joysoftgo.base_mvvm.data.database.AppDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RoomModule {
//    @Provides
//    @Singleton
//    fun provideAppDatabase(
//        app: Application
//    ): AppDatabase =
//        Room.databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME).build()
//
//    @Provides
//    @Singleton
//    fun providePhotoDao(dataBase: AppDatabase) = dataBase.photoDao()
//}