package com.mirconti.pocketlinks.domain.usecases

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.repository.CategoriesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class InsertCategoryUC @Inject constructor(val categoriesRepository: CategoriesRepository) {
    suspend operator fun invoke(category: CategoryModel) {
        categoriesRepository.addCategory(category)
    }
}