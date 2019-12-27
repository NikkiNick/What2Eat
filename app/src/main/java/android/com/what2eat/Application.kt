package android.com.what2eat

import android.app.Application
import android.com.what2eat.injection.DaggerInjectionGraph
import android.com.what2eat.injection.DatabaseModule
import android.com.what2eat.injection.InjectionGraph
import android.com.what2eat.injection.NetworkModule

/**
 * Deze Application wordt gebruikt doorheen de applicatie waarbij de [InjectionGraph] geinitialiseerd wordt
 * voor dependency injection
 */
class Application : Application() {
    companion object {
        lateinit var component: InjectionGraph
    }

    /**
     * Deze functie wordt opgeroepen wanneer de Application aangemaakt wordt. Hierbij wordt de
     * [InjectionGraph] geinitialiseerd.
     */
    override fun onCreate() {
        super.onCreate()
        component = DaggerInjectionGraph
            .builder()
            .databaseModule(DatabaseModule(this))
            .networkModule(NetworkModule())
            .build()

    }
}
