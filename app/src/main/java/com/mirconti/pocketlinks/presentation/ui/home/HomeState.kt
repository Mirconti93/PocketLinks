package com.mirconti.pocketlinks.presentation.ui.home

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel

data class HomeState(val isLoading: Boolean = false, val links: List<LinkModel> = emptyList(), val selectedCategories: List<CategoryModel> = emptyList())