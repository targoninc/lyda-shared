package com.example.lydaandroid.model

import com.beust.klaxon.Json

enum class Visibility(val value: String) {
    @Json(name = "public")
    PUBLIC("public"),

    @Json(name = "private")
    PRIVATE("private")
}
