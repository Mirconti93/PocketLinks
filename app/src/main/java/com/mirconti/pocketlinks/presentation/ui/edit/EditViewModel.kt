package com.mirconti.pocketlinks.presentation.ui.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.CategoriesRepository
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import com.mirconti.pocketlinks.commons.DataHelper
import kotlinx.coroutines.launch
import javax.inject.Inject

class EditViewModel @Inject constructor(val linksRepository: LinksRepository, val categoriesRepository: CategoriesRepository): ViewModel()  {
    val linkModel : LiveData<LinkModel> get() = _linkModel
    private val _linkModel = MutableLiveData<LinkModel>(DataHelper.buildEmptyLink())

    fun addLink() {
        _linkModel.value?.let {
            viewModelScope.launch {
                linksRepository.addLink(it)
            }
        }

    }
}