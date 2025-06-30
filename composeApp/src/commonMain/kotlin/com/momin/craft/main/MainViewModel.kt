package com.momin.craft.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momin.craft.core.domain.repository.settings.AppSettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    appSettingsRepository: AppSettingsRepository
): ViewModel() {

    val isOnboardingCompleted : StateFlow<Boolean> = appSettingsRepository.getUserName()
        .map { !it.isNullOrEmpty() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = false
        )
}