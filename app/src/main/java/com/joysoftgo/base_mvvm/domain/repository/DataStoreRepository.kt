package com.joysoftgo.base_mvvm.domain.repository

import javax.inject.Singleton

@Singleton
interface DataStoreRepository {
    suspend fun savePassword(password: String)

    suspend fun getPassword(): String
}