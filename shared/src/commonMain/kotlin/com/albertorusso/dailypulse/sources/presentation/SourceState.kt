package com.albertorusso.dailypulse.sources.presentation

import com.albertorusso.dailypulse.sources.domain.Source

data class SourceState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
