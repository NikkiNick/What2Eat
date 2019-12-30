package android.com.what2eat.database

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdMaaltijdOnderdeel
import android.com.what2eat.model.MaaltijdOnderdeel
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Room database voor maaltijden, maaltijdonderdelen en een JOIN table voor many-to-many relaties
 * @property maaltijdDao DAO voor Room-operaties voor maaltijden
 * @property maaltijdOnderdeelDao DAO voor Room-operaties voor maaltijdOnderdelen
 * @property maaltijdMaaltijdOnderdeelDao DAO voor Room-operaties voor many-to-many relaties tussen maaltijden en maaltijdOnderdelen
 */
@Database(entities = [Maaltijd::class, MaaltijdOnderdeel::class, MaaltijdMaaltijdOnderdeel::class], version = 15, exportSchema = false)
abstract class MaaltijdDatabase: RoomDatabase() {

    abstract val maaltijdDao: MaaltijdDao
    abstract val maaltijdOnderdeelDao: MaaltijdOnderdeelDao
    abstract val maaltijdMaaltijdOnderdeelDao: MaaltijdMaaltijdOnderdeelDao

    /**
     * Companion object voor Database
     * @property INSTANCE Database instantie
     */
    companion object{

        @Volatile
        private var INSTANCE: MaaltijdDatabase? = null

        /**
         * Functie die de database instantie teruggeeft. Als de database reeds bestaat, wordt deze
         * teruggegeven. Zoniet wordt deze eerst geïnstantieerd.
         * @param context Context
         * @return MaaltijdDatabase
         */
        fun getInstance(context: Context): MaaltijdDatabase {

            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext, MaaltijdDatabase::class.java, "maaltijden_database")
                                    .fallbackToDestructiveMigration()
                                    .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}