[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdOnderdeelDetailViewModel](./index.md)

# MaaltijdOnderdeelDetailViewModel

`class MaaltijdOnderdeelDetailViewModel : ViewModel`

ViewModel voor business logica rond een bepaald maaltijdOnderdeel in detail.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelDetailViewModel(maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>ViewModel voor business logica rond een bepaald maaltijdOnderdeel in detail. |

### Properties

| Name | Summary |
|---|---|
| [maaltijdOnderdeel](maaltijd-onderdeel.md) | `val maaltijdOnderdeel: LiveData<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>`<br>[MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) waarrond het ViewModel opgebouwd is |
| [maaltijdOnderdeelRepo](maaltijd-onderdeel-repo.md) | `lateinit var maaltijdOnderdeelRepo: `[`MaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-onderdeel-repository/index.md)<br>Injected properties |
| [maaltijdOnderdeel_id](maaltijd-onderdeel_id.md) | `val maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Id van het maaltijdOnderdeel waarrond het ViewModel is opgebouwd |
| [maaltijdRepo](maaltijd-repo.md) | `lateinit var maaltijdRepo: `[`MaaltijdRepository`](../../android.com.what2eat.repositories/-maaltijd-repository/index.md)<br>Repository voor Room databank operaties voor maaltijden |
| [maaltijden](maaltijden.md) | `val maaltijden: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?>`<br>Lijst van [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) die bij het maaltijdOnderdeel horen |
| [showSnackBar](show-snack-bar.md) | `val showSnackBar: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob`<br>CoRoutine properties |

### Functions

| Name | Summary |
|---|---|
| [deleteMaaltijdOnderdeel](delete-maaltijd-onderdeel.md) | `fun deleteMaaltijdOnderdeel(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die het huidige maaltijdOnderdeel verwijderd in de Room-databank. Als het maaltijdOnderdeel nog verbonden is met maaltijden kan deze niet verwijderd worden. |
| [initializeMaaltijdOnderdeel](initialize-maaltijd-onderdeel.md) | `fun initializeMaaltijdOnderdeel(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die het huidige maaltijdOnderdeel ophaalt van de Room-databank aan de hand van de maaltijdOnderdeelId waarmee het ViewModel gecreëert is, alsook de maaltijden waaraan het maaltijdOndedeel gelinkt zijn. |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt opgeroepen als het ViewModel wordt afgebroken. [viewModelJob](view-model-job.md) wordt afgesloten. |
| [setNaam](set-naam.md) | `fun setNaam(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Business logica voor het aanpassen van de naam van het maaltijdOnderdeel |
