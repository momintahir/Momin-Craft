package com.momin.craft.core.data.repository.settings

import com.momin.craft.core.data.local.PreferenceManager
import com.momin.craft.core.domain.repository.settings.AppSettingsRepository
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImp(
    private val preferenceManager: PreferenceManager
): AppSettingsRepository {
    override fun saveUsername(value: String) {
        preferenceManager.setString(key = PreferenceManager.USERNAME, value = value)
    }

    override fun getUserName(): Flow<String?> {
        return preferenceManager.getString(key = PreferenceManager.USERNAME)
    }
}