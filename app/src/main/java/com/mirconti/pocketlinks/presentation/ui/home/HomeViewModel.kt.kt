package com.mirconti.pocketlinks.presentation.ui.home

import LinksByCategoryUC
import androidx.compose.runtime.mutableStateOf
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

    val selectedCategories : StateFlow<HomeState> get() =  _state
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())


    fun onAction(action: HomeAction) {
        when(action) {
            is HomeAction.Load -> {
                viewModelScope.launch {
                    _state.value = HomeState(isLoading = true)
                    val allLinks = withContext(Dispatchers.IO) { getAllLinksUC() }
                    _state.value = HomeState(isLoading = false, links = allLinks)
                }
            }
        }
    }

}