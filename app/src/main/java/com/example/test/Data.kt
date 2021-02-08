package com.example.test

data class Data(val title: String, val value: String) {
    fun getData() = "$title $value \n"
}