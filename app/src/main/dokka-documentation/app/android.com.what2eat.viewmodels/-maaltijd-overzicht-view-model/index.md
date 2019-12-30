[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdOverzichtViewModel](./index.md)

# MaaltijdOverzichtViewModel

`class MaaltijdOverzichtViewModel : ViewModel`

ViewModel voor business logica rond een overzicht van maaltijden.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOverzichtViewModel()`<br>ViewModel voor business logica rond een overzicht van maaltijden. |

### Properties

| Name | Summary |
|---|---|
| [maaltijdRepo](maaltijd-repo.md) | `lateinit var maaltijdRepo: `[`MaaltijdRepository`](../../android.com.what2eat.repositories/-maaltijd-repository/index.md)<br>Injected properties |
| [maaltijden](maaltijden.md) | `val maaltijden: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>>`<br>Lijst van [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) waarrond het ViewModel opgebouwd is |
| [navigateToMaaltijdDetail](navigate-to-maaltijd-detail.md) | `val navigateToMaaltijdDetail: MutableLiveData<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>` |
| [navigateToMaaltijdEdit](navigate-to-maaltijd-edit.md) | `val navigateToMaaltijdEdit: MutableLiveData<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>` |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob`<br>CoRoutine Properties |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijd](add-maaltijd.md) | `fun addMaaltijd(maaltijd_naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die een nieuwe maaltijd toevoegd in de Room-databank. Hierbij wordt ook de LiveData aangepast om het fragment te verwittigen dat er dient genavigeeerd te worden naar het Edit scherm voor de nieuwe maaltijd |
| [filterMaaltijden](filter-maaltijden.md) | `fun filterMaaltijden(filter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie filtered maaltijden aan de hand van user-input in de SearchView vertrekkende van de originele maaltijdenlijst. |
| [initMaaltijden](init-maaltijden.md) | `fun initMaaltijden(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie initialiseerd de maaltijden voor het ViewModel. |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt opgeroepen als het ViewModel wordt afgebroken. [viewModelJob](view-model-job.md) wordt afgesloten. |
| [onDetailNavigated](on-detail-navigated.md) | `fun onDetailNavigated(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het resetten van de LiveData wanneer het fragment heeft genavigeerd naar het Detail scherm van een geselecteerde maaltijd |
| [onMaaltijdClicked](on-maaltijd-clicked.md) | `fun onMaaltijdClicked(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie voor het aanpassen van de LiveData om het fragment te verwittigen te navigeren naar het Detail scherm voor de geselecteerde maaltijd uit het overzicht. |
