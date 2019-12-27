package android.com.what2eat.injection


import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.repositories.MaaltijdMaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdRepository
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Database Module voor Dagger dependency injection
 * @param application ApplicationContext gebruikt om te initialiseren
 */
@Module
class DatabaseModule(private val application: Application) {

    /**
     * Voorzien van ApplicationContext singleton
     * @return Context
     */
    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return application.applicationContext
    }

    /**
     * Voorzien van Application singleton
     * @return Application
     */
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    /**
     * Voorzien van Database ([MaaltijdDatabase]) singleton
     * @param context Context gebruikt om database instantie aan te maken
     * @return [MaaltijdDatabase]
     */
    @Provides
    @Singleton
    internal fun provideDatabaseInstance(context: Context): MaaltijdDatabase{
        return MaaltijdDatabase.getInstance(context)
    }

    /**
     * Voorzien van DAO voor maaltijden([MaaltijdDao]) singleton
     * @param maaltijdDatabase Database instantie gebruikt om MaaltijdDao instantie aan te maken
     * @return [MaaltijdDao]
     */
    @Provides
    @Singleton
    internal fun provideMaaltijdDao(maaltijdDatabase: MaaltijdDatabase): MaaltijdDao{
        return maaltijdDatabase.maaltijdDao
    }

    /**
     * Voorzien van DAO voor maaltijdOnderdelen([MaaltijdOnderdeelDao]) singleton
     * @param maaltijdDatabase Database instantie gebruikt om MaaltijdOnderdeelDao instantie aan te maken
     * @return [MaaltijdOnderdeelDao]
     */
    @Provides
    @Singleton
    internal fun provideMaaltijdOnderdeelDao(maaltijdDatabase: MaaltijdDatabase): MaaltijdOnderdeelDao{
        return maaltijdDatabase.maaltijdOnderdeelDao
    }

    /**
     * Voorzien van DAO voor maaltijdMaaltijdOnderdelen([MaaltijdMaaltijdOnderdeelDao]) singleton
     * @param maaltijdDatabase Database instantie gebruikt om MaaltijdMaaltijdOnderdeelDao instantie aan te maken
     * @return [MaaltijdMaaltijdOnderdeelDao]
     */
    @Provides
    @Singleton
    internal fun provideMaaltijdMaaltijdOnderdeelDao(maaltijdDatabase: MaaltijdDatabase): MaaltijdMaaltijdOnderdeelDao{
        return maaltijdDatabase.maaltijdMaaltijdOnderdeelDao
    }

    /**
     * Voorzien van repository voor maaltijden([MaaltijdRepository]) singleton
     * @param maaltijdDao DAO instantie gebruikt om MaaltijdRepository instantie aan te maken
     * @return [MaaltijdRepository]
     */
    @Provides
    @Singleton
    internal fun provideMaaltijdRepo(maaltijdDao: MaaltijdDao): MaaltijdRepository{
        return MaaltijdRepository(maaltijdDao)
    }

    /**
     * Voorzien van repository voor maaltijdOnderdelen([MaaltijdOnderdeelRepository]) singleton
     * @param maaltijdOnderdeelDao DAO instantie gebruikt om MaaltijdOnderdeelRepository instantie aan te maken
     * @return [MaaltijdOnderdeelRepository]
     */
    @Provides
    @Singleton
    internal fun provideMaaltijdOnderdeelRepo(maaltijdOnderdeelDao: MaaltijdOnderdeelDao): MaaltijdOnderdeelRepository {
        return MaaltijdOnderdeelRepository(maaltijdOnderdeelDao)
    }

    /**
     * Voorzien van repository voor maaltijdMaaltijdOnderdelen([MaaltijdMaaltijdOnderdeelRepository]) singleton
     * @param maaltijdMaaltijdOnderdeelDao DAO instantie gebruikt om MaaltijdMaaltijdOnderdeelRepository instantie aan te maken
     * @return [MaaltijdMaaltijdOnderdeelRepository]
     */
    @Provides
    @Singleton
    internal fun provideMaaltijdMaaltijdOnderdeelRepo(maaltijdMaaltijdOnderdeelDao: MaaltijdMaaltijdOnderdeelDao): MaaltijdMaaltijdOnderdeelRepository {
        return MaaltijdMaaltijdOnderdeelRepository(maaltijdMaaltijdOnderdeelDao)
    }
}