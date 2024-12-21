package com.mircontapp.sportalbum.commons.di

import LinksByCategoryUC
import com.mircontapp.sportalbum.data.datasource.DatabaseDataSource
import com.mirconti.pocketlinks.domain.datasource.PocketDataSource
import com.mircontapp.sportalbum.data.repository.CategoriesRepositoryImpl
import com.mircontapp.sportalbum.data.repository.LinksRepositoryImpl
import com.mircontapp.sportalbum.domain.repository.CategoriesRepository
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import com.mirconti.pocketlinks.domain.usecases.GetAllLinksUC
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

    @Provides
    fun provideGetAllLinksUC(): GetAllLinksUC {
        return GetAllLinksUC(provideTeamsRepository())
    }

    @Provides
    fun provideLinksByCategoryUC(): LinksByCategoryUC {
        return LinksByCategoryUC(provideTeamsRepository())
    }


}