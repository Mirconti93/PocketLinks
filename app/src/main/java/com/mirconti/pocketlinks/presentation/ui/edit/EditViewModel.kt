package com.mirconti.pocketlinks.presentation.ui.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.CategoriesRepository
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import com.mirconti.pocketlinks.commons.DataHelper
import com.mirconti.pocketlinks.presentation.ui.home.HomeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EditViewModel @Inject constructor(val linksRepository: LinksRepository, val categoriesRepository: CategoriesRepository): ViewModel()  {

    val state : StateFlow<HomeState> get() =  _state
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())

    fun onAction(editAction: EditAction) {
        when (editAction) {
            is EditAction.Load -> _state.value = _state.value.copy(isLoading = true)
            is EditAction.AddLink -> {
                onAction(EditAction.Load)
                viewModelScope.launch {
                    editAction.categories?.let {
                        editAction.linkModel.categories = it
                        it.forEach {
                            launch(Dispatchers.IO) {
                                categoriesRepository.addCategory(it)
                            }
                        }
                    }
                    linksRepository.addLink(editAction.linkModel)
                    withContext(Dispatchers.Main) {
                        _state.value = _state.value.copy(isLoading = false)
                    }
                }
            }
        }
    }
}