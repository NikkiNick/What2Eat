package android.com.what2eat

import android.com.what2eat.activities.MainActivity
import android.com.what2eat.fragments.MaaltijdOverzichtFragment
import android.com.what2eat.viewmodels.MaaltijdOverzichtViewModel
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class MaaltijdOverzichtInstrumentedTest {

    private lateinit var viewModel: MaaltijdOverzichtViewModel
    private lateinit var fragment: MaaltijdOverzichtFragment
    @get:Rule
    public val testRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun init() {
        viewModel = MaaltijdOverzichtViewModel()
    }

    @Test
    fun emptyOverview_hidesRecyclerView(){
        fragment = startFragment()

        Espresso.onView(withId(R.id.searchView)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        Espresso.onView(withId(R.id.recycler_maaltijden)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))


    }
    private fun startFragment(): MaaltijdOverzichtFragment {
        val activity: MainActivity = testRule.getActivity() as MainActivity
        val transaction: FragmentTransaction = activity.supportFragmentManager.beginTransaction()
        val mFragment = MaaltijdOverzichtFragment()
        transaction.add(mFragment, "mFragment")
        transaction.commit()
        return mFragment
    }

}
