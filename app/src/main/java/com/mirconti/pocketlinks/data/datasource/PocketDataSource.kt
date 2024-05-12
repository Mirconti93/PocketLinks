package com.mircontapp.sportalbum.data.datasource

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel

interface PocketDataSource {
    abstract suspend fun fetchLinks(): List<CategoryModel>?
    abstract suspend fun fetchCategories(): List<LinkModel>?

    abstract suspend fun insertLink(categoryModel: CategoryModel)
    abstract suspend fun updateCategory(categoryModel: CategoryModel)

    abstract suspend fun updateTeam(linkModel: LinkModel)
    abstract suspend fun insertTeam(linkModel: LinkModel)

}