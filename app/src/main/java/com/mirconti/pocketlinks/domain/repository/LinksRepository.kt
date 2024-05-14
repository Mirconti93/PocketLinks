package com.mircontapp.sportalbum.domain.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel

interface LinksRepository {
    suspend fun getAllLinks(): List<LinkModel>
    suspend fun addLink(LinkModel: LinkModel)
    suspend fun deleteLink(linkModel: LinkModel)
    suspend fun linksFromCategory(category: String) : List<LinkModel>


}