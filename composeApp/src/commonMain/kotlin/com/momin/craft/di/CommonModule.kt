package com.momin.craft.di

import com.momin.craft.core.data.local.PreferenceManager
import com.momin.craft.core.data.repository.settings.SettingsRepositoryImp
import com.momin.craft.core.domain.repository.settings.AppSettingsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun commonModule() = module {
    /**
     * Multiplatform-Settings
     */
    single<PreferenceManager> {
        PreferenceManager(settings = get())
    }

    /**
     * Repositories
     */
    single<AppSettingsRepository> {
        SettingsRepositoryImp(
            preferenceManager = get(),
        )
    }
}

expect fun platformModule(): Module