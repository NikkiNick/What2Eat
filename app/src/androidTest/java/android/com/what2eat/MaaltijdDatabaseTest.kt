package android.com.what2eat

import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.model.Maaltijd
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class MaaltijdDatabaseTest {

    private lateinit var maaltijdDao: MaaltijdDatabaseDao
    private lateinit var db: MaaltijdDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, MaaltijdDatabase::class.java)
                .allowMainThreadQueries()
                .build()
        maaltijdDao = db.maaltijdDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetMaaltijd() {
        val expected = "Nick"
        val maaltijd = Maaltijd()
        maaltijd.naam = expected
        maaltijd.maaltijdId = 1L
        maaltijdDao.deleteAll()
        maaltijdDao.insert(maaltijd)
        val latest: Maaltijd = maaltijdDao.get(1L)
        val actual = latest.naam
        assertEquals(expected, actual)
    }
}