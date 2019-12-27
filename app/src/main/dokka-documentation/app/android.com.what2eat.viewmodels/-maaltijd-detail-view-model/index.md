[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdDetailViewModel](./index.md)

# MaaltijdDetailViewModel

`class MaaltijdDetailViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdDetailViewModel(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [changeRatingDisplay](change-rating-display.md) | `val changeRatingDisplay: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [maaltijd](maaltijd.md) | `val maaltijd: LiveData<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>` |
| [maaltijdId](maaltijd-id.md) | `val maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [maaltijdMaaltijdOnderdeelRepo](maaltijd-maaltijd-onderdeel-repo.md) | `lateinit var maaltijdMaaltijdOnderdeelRepo: `[`MaaltijdMaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-maaltijd-onderdeel-repository/index.md) |
| [maaltijdOnderdeelRepo](maaltijd-onderdeel-repo.md) | `lateinit var maaltijdOnderdeelRepo: `[`MaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-onderdeel-repository/index.md) |
| [maaltijdOnderdelen](maaltijd-onderdelen.md) | `val maaltijdOnderdelen: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?>` |
| [maaltijdRepo](maaltijd-repo.md) | `lateinit var maaltijdRepo: `[`MaaltijdRepository`](../../android.com.what2eat.repositories/-maaltijd-repository/index.md) |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob` |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijdOnderdelenToMaaltijd](add-maaltijd-onderdelen-to-maaltijd.md) | `fun addMaaltijdOnderdelenToMaaltijd(maaltijdOnderdeelIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteMaaltijd](delete-maaltijd.md) | `fun deleteMaaltijd(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [initializeMaaltijd](initialize-maaltijd.md) | `fun initializeMaaltijd(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeMaaltijdOnderdeelFromMaaltijd](remove-maaltijd-onderdeel-from-maaltijd.md) | `fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeMaaltijdPhoto](remove-maaltijd-photo.md) | `fun removeMaaltijdPhoto(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [saveMaaltijd](save-maaltijd.md) | `fun saveMaaltijd(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setMaaltijdPhoto](set-maaltijd-photo.md) | `fun setMaaltijdPhoto(uri: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setNaam](set-naam.md) | `fun setNaam(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setRating](set-rating.md) | `fun setRating(rating: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
