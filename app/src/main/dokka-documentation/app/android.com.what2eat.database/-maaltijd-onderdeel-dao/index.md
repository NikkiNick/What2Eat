[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdOnderdeelDao](./index.md)

# MaaltijdOnderdeelDao

`interface MaaltijdOnderdeelDao`

DataAccessObject om Room-database operaties uit te voeren voor [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) entities

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `abstract fun delete(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) te verwijderen |
| [get](get.md) | `abstract fun get(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`?`<br>Room-database operatie om een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) op te halen aan de hand van een opgegeven id |
| [getAll](get-all.md) | `abstract fun getAll(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`<br>Room-database operatie om alle [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) op te halen (DESC order) |
| [getMaaltijdOnderdelenNietVanMaaltijd](get-maaltijd-onderdelen-niet-van-maaltijd.md) | `abstract fun getMaaltijdOnderdelenNietVanMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`<br>Room-database om alle [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) op te halen die bij niet een opgegeven [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) horen |
| [getMaaltijdOnderdelenVanMaaltijd](get-maaltijd-onderdelen-van-maaltijd.md) | `abstract fun getMaaltijdOnderdelenVanMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`<br>Room-database om alle [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) op te halen die bij een opgegeven [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) horen |
| [insert](insert.md) | `abstract fun insert(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Room-database operatie om een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) toe te voegen |
| [update](update.md) | `abstract fun update(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) aan te passen |
