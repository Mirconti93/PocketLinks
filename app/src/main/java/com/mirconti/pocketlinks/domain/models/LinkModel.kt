package com.mircontapp.sportalbum.domain.models

data class LinkModel(
    val name: String,
    val url: String,
    val category: String?,
    val tag: String?,
    val favourite: Boolean?
)