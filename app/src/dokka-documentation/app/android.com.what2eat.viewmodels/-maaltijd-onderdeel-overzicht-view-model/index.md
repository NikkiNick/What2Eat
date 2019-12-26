[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdOnderdeelOverzichtViewModel](./index.md)

# MaaltijdOnderdeelOverzichtViewModel

`class MaaltijdOnderdeelOverzichtViewModel : ViewModel`

### Constructors

| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelOverzichtViewModel()` |

### Properties

| [maaltijdOnderdeelRepo](maaltijd-onderdeel-repo.md) | `lateinit var maaltijdOnderdeelRepo: `[`MaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-onderdeel-repository/index.md) |
| [maaltijdOnderdelen](maaltijd-onderdelen.md) | `val maaltijdOnderdelen: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>>` |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob` |

### Functions

| [addMaaltijdOnderdeel](add-maaltijd-onderdeel.md) | `fun addMaaltijdOnderdeel(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [filterMaaltijdOnderdelen](filter-maaltijd-onderdelen.md) | `fun filterMaaltijdOnderdelen(filter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [initMaaltijdOnderdelen](init-maaltijd-onderdelen.md) | `fun initMaaltijdOnderdelen(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

