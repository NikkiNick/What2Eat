[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdDao](./index.md)

# MaaltijdDao

`interface MaaltijdDao`

DataAccessObject om Room-database operaties uit te voeren voor [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) entities

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `abstract fun delete(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om een [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) te verwijderen |
| [deleteAll](delete-all.md) | `abstract fun deleteAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om alle [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) te verwijderen |
| [get](get.md) | `abstract fun get(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`?`<br>Room-database operatie om een [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) op te halen aan de hand van een opgegeven id |
| [getAll](get-all.md) | `abstract fun getAll(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?`<br>Room-database operatie om alle [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) op te halen (DESC order) |
| [getMaaltijdenFromMaaltijdOnderdeel](get-maaltijden-from-maaltijd-onderdeel.md) | `abstract fun getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?`<br>Room-database operatie om alle [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) op te halen die een opgegeven maaltijdOnderdeel bevat |
| [insert](insert.md) | `abstract fun insert(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Room-database operatie om een [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) toe te voegen |
| [update](update.md) | `abstract fun update(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om een [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) aan te passen |
