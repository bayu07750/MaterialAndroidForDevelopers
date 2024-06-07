package com.bayudevkt.materialandroidfordevelopers.initializer

import android.content.Context
import androidx.startup.Initializer
import com.bayudevkt.materialandroidfordevelopers.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Timber.d("TimberInitializer is initialized.")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}