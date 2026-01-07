package com.mircontapp.sportalbum.domain.models

data class LinkModel(
    val name: String,
    val url: String,
    var categories: List<CategoryModel> = emptyList(),
    val type: String? = null,
    val favourite: Boolean? = false
)