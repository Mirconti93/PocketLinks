package com.mirconti.pocketlinks.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.CategoriesRepository
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(val linksRepository: LinksRepository, val categoriesRepository: CategoriesRepository): ViewModel()  {
    val categories : StateFlow<List<CategoryModel>> get() =  _categories
    private val _categories: MutableStateFlow<List<CategoryModel>> = MutableStateFlow(emptyList())

    val selectedCategories : StateFlow<List<String>> get() =  _selectedCategories
    private val _selectedCategories: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

    val links : StateFlow<List<LinkModel>> get() =  _links
    private val _links: MutableStateFlow<List<LinkModel>> = MutableStateFlow(emptyList())

    private val _allLinks = MutableLiveData<List<LinkModel>>(emptyList())

    fun fetchLinks() {
        viewModelScope.launch(Dispatchers.IO) {
            val allLinks = linksRepository.getAllLinks()
            withContext(Dispatchers.Main) {
                _allLinks.value = allLinks
            }
        }
    }

    fun linksByCategoreies() {
        viewModelScope.launch(Dispatchers.IO) {
            val filteredLinks = linksRepository.linksFromCategories(selectedCategories.value)
            withContext(Dispatchers.Main) {
                _links.value = filteredLinks
            }
        }

    }
}