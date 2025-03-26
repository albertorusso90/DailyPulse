package com.albertorusso.dailypulse.sources.presentation

import com.albertorusso.dailypulse.BaseViewModel
import com.albertorusso.dailypulse.sources.domain.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(
    private val sourcesUseCase: SourcesUseCase
) : BaseViewModel() {

    private val _sourceState: MutableStateFlow<SourceState> = MutableStateFlow(SourceState(loading = true))
    val sourceState: StateFlow<SourceState> get() = _sourceState

    init {
        getSources()
    }

    private fun getSources() {
        scope.launch {
            _sourceState.emit(SourceState(loading = true))

            val fetchedSources = sourcesUseCase.getSources()
            _sourceState.emit(SourceState(sources = fetchedSources))
        }
    }
}