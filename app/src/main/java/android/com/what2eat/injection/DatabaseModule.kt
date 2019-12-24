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
 * Provides the Database Service implemenation
 * @param application the applicationContext used to instantiate the service
 */
@Module
class DatabaseModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return application.applicationContext
    }
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }
    @Provides
    @Singleton
    internal fun provideDatabaseInstance(context: Context): MaaltijdDatabase{
        return MaaltijdDatabase.getInstance(context)
    }
    @Provides
    @Singleton
    internal fun provideMaaltijdDao(maaltijdDatabase: MaaltijdDatabase): MaaltijdDao{
        return maaltijdDatabase.maaltijdDao
    }
    @Provides
    @Singleton
    internal fun provideMaaltijdOnderdeelDao(maaltijdDatabase: MaaltijdDatabase): MaaltijdOnderdeelDao{
        return maaltijdDatabase.maaltijdOnderdeelDao
    }
    @Provides
    @Singleton
    internal fun provideMaaltijdMaaltijdOnderdeelDao(maaltijdDatabase: MaaltijdDatabase): MaaltijdMaaltijdOnderdeelDao{
        return maaltijdDatabase.maaltijdMaaltijdOnderdeelDao
    }

    @Provides
    @Singleton
    internal fun provideMaaltijdRepo(maaltijdDao: MaaltijdDao): MaaltijdRepository{
        return MaaltijdRepository(maaltijdDao)
    }
    @Provides
    @Singleton
    internal fun provideMaaltijdOnderdeelRepo(maaltijdOnderdeelDao: MaaltijdOnderdeelDao): MaaltijdOnderdeelRepository {
        return MaaltijdOnderdeelRepository(maaltijdOnderdeelDao)
    }
    @Provides
    @Singleton
    internal fun provideMaaltijdMaaltijdOnderdeelRepo(maaltijdMaaltijdOnderdeelDao: MaaltijdMaaltijdOnderdeelDao): MaaltijdMaaltijdOnderdeelRepository {
        return MaaltijdMaaltijdOnderdeelRepository(maaltijdMaaltijdOnderdeelDao)
    }
}