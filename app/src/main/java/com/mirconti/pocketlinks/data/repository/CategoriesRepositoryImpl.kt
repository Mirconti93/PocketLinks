package com.mircontapp.sportalbum.data.repository

import com.mirconti.pocketlinks.domain.datasource.PocketDataSource
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.repository.CategoriesRepository


class CategoriesRepositoryImpl(val pocketDataSource: PocketDataSource): CategoriesRepository {

    override suspend fun addCategory(categoryModel: CategoryModel) {
        pocketDataSource.insertCategory(categoryModel)
    }

    override suspend fun updateCategory(categoryModel: CategoryModel) {
        pocketDataSource.updateCategory(categoryModel)
    }

    override suspend fun getAllCategories(): List<CategoryModel> {
        return pocketDataSource.fetchCategories() ?: emptyList()
    }

    override suspend fun deleteCategory(categoryModel: CategoryModel) {
        pocketDataSource.deleteCategory(categoryModel)
    }

    override suspend fun getAllSubcategories(category: String): List<CategoryModel>  {
        return getAllCategories().filter { category == it.categoryUp }
    }

}