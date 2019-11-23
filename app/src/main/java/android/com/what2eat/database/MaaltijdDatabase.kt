package android.com.what2eat.database

import android.com.what2eat.model.Maaltijd
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Maaltijd::class], version = 1, exportSchema = false)
public abstract class MaaltijdDatabase: RoomDatabase() {

    abstract val maaltijdDatabaseDao: MaaltijdDatabaseDao

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