package com.mirconti.pocketlinks.presentation.ui.home

import LinksByCategoryUC
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.CategoriesRepository
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import com.mirconti.pocketlinks.domain.usecases.GetAllLinksUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(val getAllLinksUC: GetAllLinksUC, val linksByCategoryUC: LinksByCategoryUC): ViewModel()  {
    val categories : StateFlow<List<CategoryModel>> get() =  _categories
    private val _categories: MutableStateFlow<List<CategoryModel>> = MutableStateFlow(emptyList())

    val selectedCategories : StateFlow<List<String>> get() =  _selectedCategories
    private val _selectedCategories: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

    val links : LiveData<List<LinkModel>> get() =  _links
    private val _links: MutableLiveData<List<LinkModel>> = MutableLiveData(emptyList())

    private val _allLinks = MutableLiveData<List<LinkModel>>(emptyList())

    fun fetchLinks() {
        viewModelScope.launch {
            val allLinks = withContext(Dispatchers.IO) { getAllLinksUC() }
            _allLinks.value = allLinks
            _links.value = allLinks
        }
    }

    fun linksByCategories(categories: List<CategoryModel>) {
        viewModelScope.launch{
            val filteredLinks = withContext(Dispatchers.IO) { linksByCategoryUC(categories) }
             _links.value = filteredLinks
        }

    }
}