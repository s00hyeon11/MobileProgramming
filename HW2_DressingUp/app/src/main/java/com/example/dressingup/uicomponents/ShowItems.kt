package com.example.dressingup.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dressingup.model.ClothingItem

@Composable
fun ShowItems(modifier: Modifier = Modifier) {
    val itemList = ClothingItem.itemList

    itemList.forEachIndexed { index, item ->

    }
}