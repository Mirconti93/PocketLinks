package com.mirconti.pocketlinks.presentation.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirconti.pocketlinks.domain.usecases.InsertLinkUC
import com.mirconti.pocketlinks.domain.usecases.InsertCategoryUC
import com.mirconti.pocketlinks.presentation.ui.home.HomeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EditViewModel @Inject constructor(val insertCategoriesUC: InsertCategoryUC, val insertLinkUC: InsertLinkUC): ViewModel()  {

    val state : StateFlow<HomeState> get() =  _state
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())

    fun onAction(editAction: EditAction) {
        when (editAction) {
            is EditAction.Load -> _state.value = _state.value.copy(isLoading = true)
            is EditAction.AddLink -> {
                onAction(EditAction.Load)
                viewModelScope.launch {
                    editAction.categories?.forEach {
                        launch {
                            insertCategoriesUC.invoke(it)
                        }
                    }
                    insertLinkUC.invoke(editAction.linkModel, editAction.categories)
                    withContext(Dispatchers.Main) {
                        _state.value = _state.value.copy(isLoading = false)
                    }
                }
            }
        }
    }
}