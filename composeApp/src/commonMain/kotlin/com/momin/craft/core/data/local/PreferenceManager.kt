package com.momin.craft.core.data.local

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.getBooleanFlow
import com.russhwolf.settings.coroutines.getIntFlow
import com.russhwolf.settings.coroutines.getIntOrNullFlow
import com.russhwolf.settings.coroutines.getLongFlow
import com.russhwolf.settings.coroutines.getStringOrNullFlow
import com.russhwolf.settings.set
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

class PreferenceManager(private val settings: Settings) {
    private val observableSettings: ObservableSettings by lazy { settings as ObservableSettings }

    @OptIn(ExperimentalSettingsApi::class)
    fun setString(key: String, value: String) {
        observableSettings.set(key = key, value = value)
    }

    @OptIn(ExperimentalSettingsApi::class)
    fun getNonFlowString(key: String) = observableSettings.getString(
        key = key,
        defaultValue = "",
    )

    @OptIn(ExperimentalCoroutinesApi::class, ExperimentalSettingsApi::class)
    fun getString(key: String) = observableSettings.getStringOrNullFlow(key = key)

    @OptIn(ExperimentalSettingsApi::class)
    fun setInt(key: String, value: Int) {
        observableSettings.set(key = key, value = value)
    }

    @OptIn(ExperimentalSettingsApi::class, ExperimentalCoroutinesApi::class)
    fun getInt(key: String) = observableSettings.getIntOrNullFlow(key = key)

    @OptIn(ExperimentalSettingsApi::class, ExperimentalCoroutinesApi::class)
    fun getIntFlow(key: String) = observableSettings.getIntFlow(key = key, defaultValue = 0)

    companion object {
        const val NOTIFICATION_OPTION = "notification_option_key"
        const val USERNAME = "username_key"
        const val SHORT_BREAK_COLOR = "short_break_color_key"
        const val LONG_BREAK_COLOR = "long_break_color_key"
        const val FOCUS_COLOR = "focus_color_key"
        const val APP_THEME = "app_theme_key"
        const val FOCUS_TIME = "focus_time_key"
        const val SHORT_BREAK_TIME = "short_break_time_key"
        const val LONG_BREAK_TIME = "long_break_time_key"
        const val HOUR_FORMAT = "hour_format_key"
    }

    @OptIn(ExperimentalSettingsApi::class)
    fun clearPreferences() {
        observableSettings.clear()
    }

    @OptIn(ExperimentalSettingsApi::class, ExperimentalCoroutinesApi::class)
    fun getBoolean(key: String): Flow<Boolean> {
        return observableSettings.getBooleanFlow(
            key = key,
            defaultValue = false,
        )
    }

    @OptIn(ExperimentalSettingsApi::class)
    fun setBoolean(key: String, value: Boolean) {
        observableSettings.set(key = key, value = value)
    }

    @OptIn(ExperimentalCoroutinesApi::class, ExperimentalSettingsApi::class)
    fun getLong(key: Any): Flow<Long?> {
        return observableSettings.getLongFlow(
            key = key.toString(),
            defaultValue = 0,
        )
    }

    fun setLong(key: String, value: Long) {
        observableSettings.set(key = key, value = value)
    }
}