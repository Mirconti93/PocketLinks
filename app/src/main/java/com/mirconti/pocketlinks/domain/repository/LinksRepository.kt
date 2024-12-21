package com.mircontapp.sportalbum.domain.repository

import com.mircontapp.sportalbum.domain.models.LinkModel

interface LinksRepository {
    suspend fun getAllLinks(): List<LinkModel>
    suspend fun addLink(LinkModel: LinkModel)
    suspend fun deleteLink(linkModel: LinkModel)
}