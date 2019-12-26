[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdMaaltijdOnderdeelRepository](./index.md)

# MaaltijdMaaltijdOnderdeelRepository

`class MaaltijdMaaltijdOnderdeelRepository`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdMaaltijdOnderdeelRepository(maaltijdMaaltijdOnderdeelDao: `[`MaaltijdMaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-maaltijd-onderdeel-dao/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [maaltijdMaaltijdOnderdeelDao](maaltijd-maaltijd-onderdeel-dao.md) | `val maaltijdMaaltijdOnderdeelDao: `[`MaaltijdMaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-maaltijd-onderdeel-dao/index.md) |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijdOnderdeelToMaaltijd](add-maaltijd-onderdeel-to-maaltijd.md) | `suspend fun addMaaltijdOnderdeelToMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteMaaltijdenMaaltijdOnderdelenJoin](delete-maaltijden-maaltijd-onderdelen-join.md) | `suspend fun deleteMaaltijdenMaaltijdOnderdelenJoin(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeMaaltijdOnderdeelFromMaaltijd](remove-maaltijd-onderdeel-from-maaltijd.md) | `suspend fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
