package android.com.what2eat.injection

import android.com.what2eat.fragments.MaaltijdEditFragment
import android.com.what2eat.viewmodels.*
import dagger.Component
import javax.inject.Singleton

/**
 * Deze InjectionGraph wordt gebruikt in de applicatie om aan te geven waar de verschillende
 * injecteerbare singletons beschikbaar gesteld moeten worden.
 */
@Singleton
@Component(modules = [DatabaseModule::class, NetworkModule::class])
interface InjectionGraph {
    fun inject(maaltijdDetailViewModel: MaaltijdDetailViewModel)
    fun inject(maaltijdOverzichtViewModel: MaaltijdOverzichtViewModel)
    fun inject(recipeApiViewModel: RecipeApiViewModel)
    fun inject(maaltijdOnderdeelOverzichtViewModel: MaaltijdOnderdeelOverzichtViewModel)
    fun inject(maaltijdOnderdeelSelectViewModel: MaaltijdOnderdeelSelectViewModel)
    fun inject(maaltijdOnderdeelDetailViewModel: MaaltijdOnderdeelDetailViewModel)
    fun inject(maaltijdEditFragment: MaaltijdEditFragment)

    @Component.Builder
    interface Builder {
        fun build(): InjectionGraph
        fun databaseModule(databaseModule: DatabaseModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
    }
}