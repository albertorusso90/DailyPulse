package com.albertorusso.dailypulse.sources.domain

data class Source(
    val name: String,
    val description: String,
    val country: String,
    val language: String
) {
    fun getCountryAndLanguage() = "$country - $language"
}