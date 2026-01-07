package com.mirconti.pocketlinks.data.remote

import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.models.toCategoryModel

data class LinkResponse(
    val name: String?,
    val categories: List<String>?,
    val url: String
)

fun LinkResponse.toLinkModel(): LinkModel {
    return LinkModel(
        name = this.name ?: "Unknown",
        categories = this.categories?.map { it.toCategoryModel() } ?: emptyList(),
        url = this.url
    )
}
