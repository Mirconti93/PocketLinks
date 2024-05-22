package com.mircontapp.sportalbum.data.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.data.datasource.PocketDataSource
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import javax.inject.Inject
import kotlin.collections.ArrayList

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

    override suspend fun linksFromCategories(categories: List<String>): List<LinkModel> {
        return getAllLinks().filter {categories.contains(it.category)}
    }


}