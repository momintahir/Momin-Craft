package com.momin.craft.core.domain.repository.settings

import kotlinx.coroutines.flow.Flow

interface AppSettingsRepository {

    fun getUserName(): Flow<String?>
    fun saveUsername(value: String)
}