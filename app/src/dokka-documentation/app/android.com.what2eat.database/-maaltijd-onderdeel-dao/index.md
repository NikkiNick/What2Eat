[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdOnderdeelDao](./index.md)

# MaaltijdOnderdeelDao

`interface MaaltijdOnderdeelDao`

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `abstract fun delete(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.md) | `abstract fun get(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`?` |
| [getAll](get-all.md) | `abstract fun getAll(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?` |
| [getMaaltijdOnderdelenNietVanMaaltijd](get-maaltijd-onderdelen-niet-van-maaltijd.md) | `abstract fun getMaaltijdOnderdelenNietVanMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?` |
| [getMaaltijdOnderdelenVanMaaltijd](get-maaltijd-onderdelen-van-maaltijd.md) | `abstract fun getMaaltijdOnderdelenVanMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?` |
| [insert](insert.md) | `abstract fun insert(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [update](update.md) | `abstract fun update(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
