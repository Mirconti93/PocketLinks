package com.mirconti.pocketlinks.domain.datasource

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel

interface PocketDataSource {
    abstract suspend fun fetchLinks(): List<LinkModel>?
    abstract suspend fun fetchCategories(): List<CategoryModel>?

    abstract suspend fun insertLink(linkModel: LinkModel)
    abstract suspend fun updateLink(linkModel: LinkModel)

    abstract suspend fun deleteLink(linkModel: LinkModel)

    abstract suspend fun insertCategory(categoryModel: CategoryModel)
    abstract suspend fun updateCategory(categoryModel: CategoryModel)

    abstract suspend fun deleteCategory(categoryModel: CategoryModel)

}