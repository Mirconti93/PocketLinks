package com.mircontapp.sportalbum.domain.models

data class LinkModel(
    val name: String,
    val url: String,
    var categories: List<CategoryModel>,
    val type: String?,
    val favourite: Boolean?
)