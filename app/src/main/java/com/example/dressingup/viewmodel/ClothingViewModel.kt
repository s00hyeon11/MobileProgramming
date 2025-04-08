package com.example.dressingup.viewmodel

import android.opengl.Visibility
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.example.dressingup.model.ClothingItem

class ClothingViewModel: ViewModel() {
    private val _visibility = mutableStateMapOf<ClothingItem, Boolean>().apply {
        ClothingItem.itemList.forEach{ put(it, true)}
    }
    val visibility: Map<ClothingItem, Boolean> get() = _visibility

    fun setVisibility(item: ClothingItem, visible: Boolean){
        _visibility[item] = visible
    }
}