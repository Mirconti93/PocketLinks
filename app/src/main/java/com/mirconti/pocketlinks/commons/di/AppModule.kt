package com.mircontapp.sportalbum.commons.di

import com.mircontapp.sportalbum.data.datasource.DatabaseDataSource
import com.mircontapp.sportalbum.data.datasource.PocketDataSource
import com.mircontapp.sportalbum.data.repository.CategoriesRepositoryImpl
import com.mircontapp.sportalbum.data.repository.LinksRepositoryImpl
import com.mircontapp.sportalbum.domain.repository.CategoriesRepository
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideAlbumDataSource(): PocketDataSource {
        //return AssetsDataSource(SportAlbumApplication.instance.applicationContext.assets)
        return DatabaseDataSource()
    }

    @Provides
    fun provideTeamsRepository(): LinksRepository {
        return LinksRepositoryImpl(provideAlbumDataSource())
    }

    @Provides
    fun providePlayersRepository(): CategoriesRepository {
        return CategoriesRepositoryImpl(provideAlbumDataSource())
    }

}