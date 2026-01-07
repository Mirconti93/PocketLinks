package com.mircontapp.sportalbum.domain.models

data class CategoryModel(
    val name: String,
    val categoryUp: String? = null,
)

fun String.toCategoryModel(): CategoryModel {
    return CategoryModel(name = this)
}