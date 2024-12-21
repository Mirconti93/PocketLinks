package com.mircontapp.sportalbum.data.repository

import com.mirconti.pocketlinks.domain.datasource.PocketDataSource
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import javax.inject.Inject

class LinksRepositoryImpl @Inject constructor(val pocketDataSource: PocketDataSource) : LinksRepository {

    override suspend fun addLink(linkModel: LinkModel) {
        pocketDataSource.insertLink(linkModel)
    }

    override suspend fun deleteLink(linkModel: LinkModel) {
        pocketDataSource.deleteLink(linkModel)
    }

    override suspend fun getAllLinks(): List<LinkModel> {
        return pocketDataSource.fetchLinks() ?: emptyList()
    }

}