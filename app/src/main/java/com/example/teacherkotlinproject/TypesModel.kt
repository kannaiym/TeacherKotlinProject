package com.example.teacherkotlinproject

var array = mutableListOf<String>()

var imageArray = mutableListOf<Int>().apply {
    add(R.mipmap.london)
    add(R.mipmap.madrid)
    add(R.mipmap.paris)
}

var cityArray = mutableListOf<City>().apply {
    add(City(R.mipmap.london, "London", "London is biggest city in British"))
    add(City(R.mipmap.madrid, "Madrid", "Madrid is biggest city in Spain"))
    add(City(R.mipmap.paris, "Paris", "Paris is biggest city in France"))
}

//    private fun setData() {
//        for (i in 1..10) {
//            array.add("Попытка # $i")
//        }
//    }
