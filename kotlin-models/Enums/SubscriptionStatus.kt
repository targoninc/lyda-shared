// To parse the JSON, install Klaxon and do:
//
//   val subscriptionStatus = SubscriptionStatus.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

typealias SubscriptionStatus = Double
