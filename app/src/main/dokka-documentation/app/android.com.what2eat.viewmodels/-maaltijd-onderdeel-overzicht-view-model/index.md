[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdOnderdeelOverzichtViewModel](./index.md)

# MaaltijdOnderdeelOverzichtViewModel

`class MaaltijdOnderdeelOverzichtViewModel : ViewModel`

ViewModel voor business logica rond een overzicht van maaltijdOnderdelen.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelOverzichtViewModel()`<br>ViewModel voor business logica rond een overzicht van maaltijdOnderdelen. |

### Properties

| Name | Summary |
|---|---|
| [maaltijdOnderdeelRepo](maaltijd-onderdeel-repo.md) | `lateinit var maaltijdOnderdeelRepo: `[`MaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-onderdeel-repository/index.md)<br>Injected properties |
| [maaltijdOnderdelen](maaltijd-onderdelen.md) | `val maaltijdOnderdelen: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>>`<br>Lijst van [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) waarrond het ViewModel opgebouwd is |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob`<br>CoRoutine properties |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijdOnderdeel](add-maaltijd-onderdeel.md) | `fun addMaaltijdOnderdeel(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die een nieuw maaltijdOnderdeel toevoegd in de Room-databank. |
| [filterMaaltijdOnderdelen](filter-maaltijd-onderdelen.md) | `fun filterMaaltijdOnderdelen(filter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie filtered maaltijdOnderdelen aan de hand van user-input in de SearchView vertrekkende van de originele maaltijdOnderdelenlijst. |
| [initMaaltijdOnderdelen](init-maaltijd-onderdelen.md) | `fun initMaaltijdOnderdelen(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie initialiseerd de maaltijdOnderdelen voor het ViewModel. |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt opgeroepen als het ViewModel wordt afgebroken. [viewModelJob](view-model-job.md) wordt afgesloten. |
