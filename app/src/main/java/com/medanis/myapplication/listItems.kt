package com.medanis.myapplication

class listItems(fruitNames : String, fruitNames2 : String, imageShow : Int) {
    private var fruitNames: String? = fruitNames
    fun getFruitNames(): String? {
        return fruitNames
    }
    fun setFruitNames(text: String) {
        this.fruitNames = text
    }

    private var fruitNames2: String? = fruitNames2
    fun getFruitNames2(): String? {
        return fruitNames2
    }
    fun setFruitNames2(text: String) {
        this.fruitNames2 = text
    }

    private var imageShow: Int? = imageShow
    fun getimageShow(): Int? {
        return imageShow
    }
    fun setimageShow(text: Int) {
        this.imageShow = text
    }



}