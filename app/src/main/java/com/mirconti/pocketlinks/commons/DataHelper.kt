package com.mirconti.pocketlinks.commons

import com.mircontapp.sportalbum.domain.models.LinkModel

class DataHelper {
    companion object {
        fun buildEmptyLink(): LinkModel {
            return LinkModel("", "", "", "", false)
        }
    }
}