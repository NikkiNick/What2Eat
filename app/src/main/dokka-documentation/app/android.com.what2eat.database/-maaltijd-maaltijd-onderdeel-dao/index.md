[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdMaaltijdOnderdeelDao](./index.md)

# MaaltijdMaaltijdOnderdeelDao

`interface MaaltijdMaaltijdOnderdeelDao`

DataAccessObject om Room-database operaties uit te voeren voor [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) entities

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `abstract fun delete(maaltijdMaaltijdOnderdeel: `[`MaaltijdMaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om een [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) te verwijderen |
| [deleteFromMaaltijd](delete-from-maaltijd.md) | `abstract fun deleteFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om alle [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) van een opgegeven [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) te verwijderen |
| [getAll](get-all.md) | `abstract fun getAll(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdMaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md)`>?`<br>Room-database operatie om alle [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) op te halen (DESC order) |
| [getFromMaaltijd](get-from-maaltijd.md) | `abstract fun getFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdMaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md)`>?`<br>Room-database operatie om alle [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) op te halen van een opgegeven [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) |
| [getFromMaaltijdOnderdeel](get-from-maaltijd-onderdeel.md) | `abstract fun getFromMaaltijdOnderdeel(maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdMaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md)`>?`<br>Room-database operatie om alle [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) op te halen van een opgegeven maaltijdOnderdeel |
| [insert](insert.md) | `abstract fun insert(maaltijdMaaltijdOnderdeel: `[`MaaltijdMaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om een [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) toe te voegen |
| [update](update.md) | `abstract fun update(maaltijdMaaltijdOnderdeel: `[`MaaltijdMaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Room-database operatie om een [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) aan te passen |
