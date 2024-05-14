package com.mircontapp.sportalbum.domain.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.domain.models.CategoryModel

interface CategoriesRepository {

    suspend fun getAllCategories(): List<CategoryModel>
    suspend fun addCategory(categoryModel: CategoryModel)
    suspend fun updateCategory(categoryModel: CategoryModel)
    suspend fun deleteCategory(categoryModel: CategoryModel)

    suspend fun getAllSubcategories(category: String): List<CategoryModel>
}