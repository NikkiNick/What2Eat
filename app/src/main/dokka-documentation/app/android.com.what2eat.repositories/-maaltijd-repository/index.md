[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdRepository](./index.md)

# MaaltijdRepository

`class MaaltijdRepository`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdRepository(maaltijdDbSource: `[`MaaltijdDao`](../../android.com.what2eat.database/-maaltijd-dao/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [maaltijdDbSource](maaltijd-db-source.md) | `val maaltijdDbSource: `[`MaaltijdDao`](../../android.com.what2eat.database/-maaltijd-dao/index.md) |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijd](add-maaltijd.md) | `suspend fun addMaaltijd(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [deleteMaaltijd](delete-maaltijd.md) | `suspend fun deleteMaaltijd(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAllMaaltijden](get-all-maaltijden.md) | `suspend fun getAllMaaltijden(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?` |
| [getMaaltijd](get-maaltijd.md) | `suspend fun getMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`?` |
| [getMaaltijdenFromMaaltijdOnderdeel](get-maaltijden-from-maaltijd-onderdeel.md) | `suspend fun getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?` |
| [saveMaaltijd](save-maaltijd.md) | `suspend fun saveMaaltijd(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
