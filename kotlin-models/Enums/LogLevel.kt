// To parse the JSON, install Klaxon and do:
//
//   val logLevel = LogLevel.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

typealias LogLevel = Double
