package com.alphabet.api_example_42

data class DataModel(
    var products : ArrayList<ProductModel>,
    var total : Int,
    var skip : Int,
    var limit : Int
)

data class ProductModel(
    var id : Int,
    var brand : String,
    var category : String,
    var description : String,
    var discountPercentage : Double,
    var images : ArrayList<String>,
    var price : Double,
    var rating : Double,
    var stock : Int,
    var thumbnail : String,
    var title : String
)
