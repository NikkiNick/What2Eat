[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdDao](./index.md)

# MaaltijdDao

`interface MaaltijdDao`

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `abstract fun delete(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteAll](delete-all.md) | `abstract fun deleteAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.md) | `abstract fun get(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`?` |
| [getAll](get-all.md) | `abstract fun getAll(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?` |
| [getMaaltijdenFromMaaltijdOnderdeel](get-maaltijden-from-maaltijd-onderdeel.md) | `abstract fun getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?` |
| [insert](insert.md) | `abstract fun insert(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [update](update.md) | `abstract fun update(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
