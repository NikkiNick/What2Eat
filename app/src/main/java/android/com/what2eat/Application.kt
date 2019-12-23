package android.com.what2eat

import android.app.Application
import android.com.what2eat.injection.DaggerInjectionGraph
import android.com.what2eat.injection.DatabaseModule
import android.com.what2eat.injection.InjectionGraph
import dagger.Component

class Application : Application() {
    companion object {
        lateinit var component: InjectionGraph
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerInjectionGraph
            .builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }
}
