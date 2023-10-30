package com.example.testApp.core

import com.example.testApp.data.repositories.remoteRepository.RemoteRepository
import com.example.testApp.data.repositories.remoteRepository.RemoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideRepository(): RemoteRepository {
        return RemoteRepositoryImpl()
    }
}