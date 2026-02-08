// To parse the JSON, install Klaxon and do:
//
//   val expense = Expense.fromJson(jsonString)

package com.example.lydaandroid.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Expense (
    @Json(name = "amount_ct")
    val amountCT: Double;

    val day: Double;

    @Json(name = "expense_group")
    val expenseGroup: String;

    val id: Double;
    val label: String;
    val month: Double;
    val year: Double;
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Expense>(json)
    }
}
