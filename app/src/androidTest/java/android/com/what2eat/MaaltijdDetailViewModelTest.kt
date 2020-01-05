package android.com.what2eat

import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.repositories.MaaltijdMaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdRepository
import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule

@RunWith(AndroidJUnit4::class)
class MaaltijdDetailViewModelTest {


    private lateinit var viewModel: MaaltijdDetailViewModel
    private lateinit var maaltijdDatabase: MaaltijdDatabase
    @Mock
    private lateinit var maaltijdRepo: MaaltijdRepository
    @Mock
    private lateinit var maaltijdOnderdeelRepo: MaaltijdOnderdeelRepository
    @Mock
    private lateinit var maaltijdMaaltijdOnderdeelRepo: MaaltijdMaaltijdOnderdeelRepository

    @Rule
    @JvmField
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUp(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        maaltijdDatabase = MaaltijdDatabase.getInstance(context)
        maaltijdRepo = MaaltijdRepository(maaltijdDatabase.maaltijdDao)

        MockitoAnnotations.initMocks(this)

        // Setting up maaltijd and maaltijdonderdelen mocks
        val maaltijd = Maaltijd()
            maaltijd.naamProperty = "Rijst en curry"
            maaltijd.rating = 5

        val maaltijdOnderdeel1 = MaaltijdOnderdeel()
            maaltijdOnderdeel1.naam = "Rijst"
        val maaltijdOnderdeel2 = MaaltijdOnderdeel()
            maaltijdOnderdeel2.naam = "Curry"
        var maaltijdOnderdelen  = mutableListOf<MaaltijdOnderdeel>()
            maaltijdOnderdelen.add(maaltijdOnderdeel1)
            maaltijdOnderdelen.add(maaltijdOnderdeel2)

        runBlocking { Mockito.`when`(maaltijdRepo.getMaaltijd(1)).thenReturn(maaltijd)}
        runBlocking { Mockito.`when`(maaltijdOnderdeelRepo.getMaaltijdOnderdelenFromMaaltijd(1)).thenReturn(maaltijdOnderdelen) }
        viewModel.maaltijdRepo = maaltijdRepo
        viewModel.maaltijdOnderdeelRepo = maaltijdOnderdeelRepo


    }
    @Test
    fun succesfull_init_maaltijdAndMaaltijdOnderdelen(){
        verify(viewModel).initializeMaaltijd()

        val maaltijd = viewModel.maaltijd.value
        maaltijd?.let{
            assertEquals("Rijst en curry", it.naamProperty)
            assertEquals(5, it.rating)
        }

        val maaltijdOnderdelen = viewModel.maaltijdOnderdelen.value
        maaltijdOnderdelen?.let{
            assertEquals(2, it.size)
            assertEquals("Rijst", it[0].naam)
            assertEquals("Curry", it[1].naam)
        }

    }
    @Test
    fun addMaaltijdOnderdeel_to_Maaltijd(){
        val maaltijdOnderdeel = MaaltijdOnderdeel()
            maaltijdOnderdeel.naam = "Melk"

        runBlocking { Mockito.`when`(maaltijdOnderdeelRepo.getMaaltijdOnderdeel(1)).thenReturn(maaltijdOnderdeel) }

        viewModel.addMaaltijdOnderdelenToMaaltijd(LongArray(1){1})
        runBlocking{ verify(maaltijdOnderdeelRepo).getMaaltijdOnderdeel(1)}

        runBlocking{ verify(maaltijdMaaltijdOnderdeelRepo.addMaaltijdOnderdeelToMaaltijd(1, 1))}

        val maaltijdOnderdelen = viewModel.maaltijdOnderdelen.value
        maaltijdOnderdelen?.let{
            assertEquals(3, it.size)
        }
    }
}

