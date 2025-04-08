package com.example.dressingup.model

import com.example.dressingup.R

sealed class ClothingItem(
    val id: String, val imageRes: Int
){
    object Arms: ClothingItem("arms", R.drawable.arms)
    object Ears: ClothingItem("ears", R.drawable.ears)
    object Eyebrows: ClothingItem("eyebrows", R.drawable.eyebrows)
    object Eyes: ClothingItem("eyes", R.drawable.eyes)
    object Glasses: ClothingItem("glasses", R.drawable.glasses)
    object Hat: ClothingItem("hat", R.drawable.hat)
    object Mouth: ClothingItem("mouth", R.drawable.mouth)
    object Mustache: ClothingItem("mustache", R.drawable.mustache)
    object Nose: ClothingItem("nose", R.drawable.nose)
    object Shoes: ClothingItem("shoes", R.drawable.shoes)

    companion object{
        val itemList = listOf(Arms, Ears, Eyebrows, Eyes, Glasses,
            Hat, Mouth, Mustache, Nose, Shoes)
    }
}