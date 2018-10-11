package br.com.heiderlopes.meusgamesroom

import android.app.Application
import com.facebook.stetho.Stetho

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)
        Stetho.initializeWithDefaults(this)
    }
}