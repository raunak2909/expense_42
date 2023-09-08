package com.alphabet.api_example_42

data class PhotoDataModel(
    var next_page : String,
    var total_results : Int,
    var per_page : Int,
    var page : Int,
    var photos : ArrayList<PhotoModel>
)

data class PhotoModel(
    val id : Int,
    val width : Int,
    val height : Int,
    val photographer_id : Int,
    val alt : String,
    val avg_color : String,
    val photographer : String,
    val photographer_url : String,
    val src : Src,
    val url : String,
    val liked : Boolean,

)

data class Src(
    var landscape : String,
    var large : String,
    var large2x : String,
    var medium : String,
    var original : String,
    var portrait : String,
    var small : String,
    var tiny : String,
)
