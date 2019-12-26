[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdOnderdeelRepository](./index.md)

# MaaltijdOnderdeelRepository

`class MaaltijdOnderdeelRepository`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelRepository(maaltijdOnderdeelDbSource: `[`MaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-onderdeel-dao/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [maaltijdOnderdeelDbSource](maaltijd-onderdeel-db-source.md) | `val maaltijdOnderdeelDbSource: `[`MaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-onderdeel-dao/index.md) |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijdOnderdeel](add-maaltijd-onderdeel.md) | `suspend fun addMaaltijdOnderdeel(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteMaaltijdOnderdeel](delete-maaltijd-onderdeel.md) | `suspend fun deleteMaaltijdOnderdeel(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAllMaaltijdOnderdelen](get-all-maaltijd-onderdelen.md) | `suspend fun getAllMaaltijdOnderdelen(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?` |
| [getAllMaaltijdOnderdelenNotFromMaaltijd](get-all-maaltijd-onderdelen-not-from-maaltijd.md) | `suspend fun getAllMaaltijdOnderdelenNotFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?` |
| [getMaaltijdOnderdeel](get-maaltijd-onderdeel.md) | `suspend fun getMaaltijdOnderdeel(maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`?` |
| [getMaaltijdOnderdelenFromMaaltijd](get-maaltijd-onderdelen-from-maaltijd.md) | `suspend fun getMaaltijdOnderdelenFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?` |
| [updateMaaltijdOnderdeel](update-maaltijd-onderdeel.md) | `suspend fun updateMaaltijdOnderdeel(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
