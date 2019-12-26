[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdOverzichtViewModel](./index.md)

# MaaltijdOverzichtViewModel

`class MaaltijdOverzichtViewModel : ViewModel`

### Constructors

| [&lt;init&gt;](-init-.md) | `MaaltijdOverzichtViewModel()` |

### Properties

| [maaltijdRepo](maaltijd-repo.md) | `lateinit var maaltijdRepo: `[`MaaltijdRepository`](../../android.com.what2eat.repositories/-maaltijd-repository/index.md) |
| [maaltijden](maaltijden.md) | `val maaltijden: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>>` |
| [navigateToMaaltijdDetail](navigate-to-maaltijd-detail.md) | `val navigateToMaaltijdDetail: MutableLiveData<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>` |
| [navigateToMaaltijdEdit](navigate-to-maaltijd-edit.md) | `val navigateToMaaltijdEdit: MutableLiveData<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>` |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob` |

### Functions

| [addMaaltijd](add-maaltijd.md) | `fun addMaaltijd(maaltijd_naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [filterMaaltijden](filter-maaltijden.md) | `fun filterMaaltijden(filter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [initMaaltijden](init-maaltijden.md) | `fun initMaaltijden(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDetailNavigated](on-detail-navigated.md) | `fun onDetailNavigated(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onMaaltijdClicked](on-maaltijd-clicked.md) | `fun onMaaltijdClicked(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

