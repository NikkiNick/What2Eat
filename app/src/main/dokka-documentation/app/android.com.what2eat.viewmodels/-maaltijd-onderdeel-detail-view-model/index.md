[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdOnderdeelDetailViewModel](./index.md)

# MaaltijdOnderdeelDetailViewModel

`class MaaltijdOnderdeelDetailViewModel : ViewModel`

### Constructors

| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelDetailViewModel(maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)` |

### Properties

| [maaltijdOnderdeel](maaltijd-onderdeel.md) | `val maaltijdOnderdeel: LiveData<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>` |
| [maaltijdOnderdeelRepo](maaltijd-onderdeel-repo.md) | `lateinit var maaltijdOnderdeelRepo: `[`MaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-onderdeel-repository/index.md) |
| [maaltijdOnderdeel_id](maaltijd-onderdeel_id.md) | `val maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [maaltijdRepo](maaltijd-repo.md) | `lateinit var maaltijdRepo: `[`MaaltijdRepository`](../../android.com.what2eat.repositories/-maaltijd-repository/index.md) |
| [maaltijden](maaltijden.md) | `val maaltijden: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?>` |
| [showSnackBar](show-snack-bar.md) | `val showSnackBar: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob` |

### Functions

| [deleteMaaltijdOnderdeel](delete-maaltijd-onderdeel.md) | `fun deleteMaaltijdOnderdeel(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [initializeMaaltijdOnderdeel](initialize-maaltijd-onderdeel.md) | `fun initializeMaaltijdOnderdeel(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setNaam](set-naam.md) | `fun setNaam(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

