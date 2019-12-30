[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdDetailViewModel](./index.md)

# MaaltijdDetailViewModel

`class MaaltijdDetailViewModel : ViewModel`

ViewModel voor business logica rond een bepaalde maaltijd in detail.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdDetailViewModel(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>ViewModel voor business logica rond een bepaalde maaltijd in detail. |

### Properties

| Name | Summary |
|---|---|
| [changeRatingDisplay](change-rating-display.md) | `val changeRatingDisplay: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [maaltijd](maaltijd.md) | `val maaltijd: LiveData<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>`<br>[Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) waarrond het ViewModel opgebouwd is |
| [maaltijdId](maaltijd-id.md) | `val maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Id van de maaltijd waarrond het ViewModel is opgebouwd |
| [maaltijdMaaltijdOnderdeelRepo](maaltijd-maaltijd-onderdeel-repo.md) | `lateinit var maaltijdMaaltijdOnderdeelRepo: `[`MaaltijdMaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-maaltijd-onderdeel-repository/index.md)<br>Repository voor Room databank operaties voor relaties tussen maaltijden en maaltijdOndedelen (JOIN table) |
| [maaltijdOnderdeelRepo](maaltijd-onderdeel-repo.md) | `lateinit var maaltijdOnderdeelRepo: `[`MaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-onderdeel-repository/index.md)<br>Repository voor Room databank operaties voor maaltijdOnderdelen |
| [maaltijdOnderdelen](maaltijd-onderdelen.md) | `val maaltijdOnderdelen: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?>`<br>Lijst van [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) die bij de maaltijd horen |
| [maaltijdRepo](maaltijd-repo.md) | `lateinit var maaltijdRepo: `[`MaaltijdRepository`](../../android.com.what2eat.repositories/-maaltijd-repository/index.md)<br>Injected properties |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob`<br>CoRoutine Properties |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijdOnderdelenToMaaltijd](add-maaltijd-onderdelen-to-maaltijd.md) | `fun addMaaltijdOnderdelenToMaaltijd(maaltijdOnderdeelIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die een Array van maaltijdOnderdeelIds kan verbinden met de huidige maaltijd in de Room-databank. Er wordt voor elk id een relatie aangemaakt (JOIN table) tussen de maaltijd en het maaltijdOnderdeel. |
| [deleteMaaltijd](delete-maaltijd.md) | `fun deleteMaaltijd(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die de huidige maaltijd verwijderd va de Room-databank, alsook de relaties die aanwezig waren voor de huidige maaltijden en eventuele maaltijdOnderdelen (JOIN table) |
| [initializeMaaltijd](initialize-maaltijd.md) | `fun initializeMaaltijd(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die de huidige maaltijd ophaalt van de Room-databank aan de hand van de maaltijdId waarmee het ViewModel gecreëert is, alsook de maaltijdOnderdelen die horen bij de maaltijd |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt opgeroepen als het ViewModel wordt afgebroken. [viewModelJob](view-model-job.md) wordt afgesloten. |
| [removeMaaltijdOnderdeelFromMaaltijd](remove-maaltijd-onderdeel-from-maaltijd.md) | `fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die maaltijdOnderdeel verwijderd van de huidige maaltijd in de Room-databank. De relatie (JOIN table) tussen de maaltijd en het maaltijdOnderdeel wordt verwijderd. |
| [removeMaaltijdPhoto](remove-maaltijd-photo.md) | `fun removeMaaltijdPhoto(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Business logica voor het verwijderen van de afbeeldingURI van de maaltijd |
| [saveMaaltijd](save-maaltijd.md) | `fun saveMaaltijd(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>CoRoutine launcher die de huidige maaltijd wijzigt in de Room-databank. |
| [setMaaltijdPhoto](set-maaltijd-photo.md) | `fun setMaaltijdPhoto(uri: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Business logica voor het aanpassen van de afbeeldingURI van de maaltijd |
| [setRating](set-rating.md) | `fun setRating(rating: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Business logica voor het aanpassen van de rating van de maaltijd |
