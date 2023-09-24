package com.example.myapplication

data class Cat(
    var name: String,
    val beforeActionTextResId: Int,
    val afterActionTextResId: Int,
    val imageResId: Int,
    val actionSoundEffectResId: Int,
) {
    fun setCatName(newName: String) {name = newName}
}
