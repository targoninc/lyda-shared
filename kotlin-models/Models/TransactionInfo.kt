// To parse the JSON, install Klaxon and do:
//
//   val transactionInfo = TransactionInfo.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class TransactionInfo (
    val paid: Double;
    val received: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<TransactionInfo>(json)
    }
}
