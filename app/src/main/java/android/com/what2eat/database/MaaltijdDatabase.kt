package android.com.what2eat.database

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdMaaltijdOnderdeel
import android.com.what2eat.model.MaaltijdOnderdeel
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Maaltijd::class, MaaltijdOnderdeel::class, MaaltijdMaaltijdOnderdeel::class], version = 7, exportSchema = false)
abstract class MaaltijdDatabase: RoomDatabase() {

    abstract val maaltijdDao: MaaltijdDao
    abstract val maaltijdOnderdeelDao: MaaltijdOnderdeelDao
    abstract val maaltijdMaaltijdOnderdeelDao: MaaltijdMaaltijdOnderdeelDao

    companion object{

        @Volatile
        private var INSTANCE: MaaltijdDatabase? = null

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