package android.com.what2eat

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class MaaltijdUnitTest {

    private lateinit var maaltijd: Maaltijd

    @Before
    fun createMaaltijd(){
        maaltijd = Maaltijd()
    }

    @Test
    fun setNaam_Maaltijd_test(){
        val expected = "maaltijd 1"
        maaltijd.naam = expected
        val actual = maaltijd.naam
        assertEquals(expected, actual)
    }

    @Test
    fun setRating_Maaltijd_test(){
        val expected = 4
        maaltijd.rating = expected
        val actual = maaltijd.rating
        assertEquals(expected, actual)
    }

    @Test
    fun setDateAdded_Maaltijd_test(){
        val expected = Date()
        maaltijd.dateAdded = expected
        val actual = maaltijd.dateAdded
        assertEquals(expected, actual)
    }

    @Test
    fun setDateLast_Maaltijd_test(){
        val expected = Date()
        maaltijd.dateLast = expected
        val actual = maaltijd.dateLast
        assertEquals(expected, actual)
    }


    @Test
    fun addMaaltijdOnderdeel_Maaltijd_test(){
        val maaltijdOnderdeel = MaaltijdOnderdeel()
        maaltijdOnderdeel.naam = "Friet"
        maaltijd.addMaaltijdOnderdeel(maaltijdOnderdeel)

        assertEquals(1, maaltijd.maaltijdOnderdelen.size)
        assertEquals("Friet", maaltijd.maaltijdOnderdelen[0].naam)
    }

    @Test
    fun removeMaaltijdOnderdeel_Maaltijd_test(){
        val maaltijdOnderdeel1 = MaaltijdOnderdeel()
        maaltijdOnderdeel1.naam = "Friet"
        maaltijd.addMaaltijdOnderdeel(maaltijdOnderdeel1)

        val maaltijdOnderdeel2 = MaaltijdOnderdeel()
        maaltijdOnderdeel2.naam = "Stoofvlees"
        maaltijd.addMaaltijdOnderdeel(maaltijdOnderdeel2)

        assertEquals(2, maaltijd.maaltijdOnderdelen.size)
        assertEquals("Friet", maaltijd.maaltijdOnderdelen[0].naam)
        assertEquals("Stoofvlees", maaltijd.maaltijdOnderdelen[1].naam)

        maaltijd.removeMaaltijdOnderdeel(maaltijdOnderdeel2)
        assertEquals(1, maaltijd.maaltijdOnderdelen.size)
        assertEquals("Friet", maaltijd.maaltijdOnderdelen[0].naam)

    }

}