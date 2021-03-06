package com.technzone.bai3.data.pref.favorite

interface FavoritePref {

    fun setFavoriteList(list : List<Int>)
    fun addFavorite(id : Int)
    fun removeFavorite(id : Int)
    fun getFavoriteList(): List<Int>
}