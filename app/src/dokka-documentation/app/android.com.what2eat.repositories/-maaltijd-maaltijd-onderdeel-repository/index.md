[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdMaaltijdOnderdeelRepository](./index.md)

# MaaltijdMaaltijdOnderdeelRepository

`class MaaltijdMaaltijdOnderdeelRepository`

Repository voor het het uitvoeren van databank-operaties voor [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md)

### Parameters

`maaltijdMaaltijdOnderdeelDao` - DAO gebruikt voor databank-operaties

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdMaaltijdOnderdeelRepository(maaltijdMaaltijdOnderdeelDao: `[`MaaltijdMaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-maaltijd-onderdeel-dao/index.md)`)`<br>Repository voor het het uitvoeren van databank-operaties voor [MaaltijdMaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-maaltijd-onderdeel/index.md) |

### Properties

| Name | Summary |
|---|---|
| [maaltijdMaaltijdOnderdeelDao](maaltijd-maaltijd-onderdeel-dao.md) | `val maaltijdMaaltijdOnderdeelDao: `[`MaaltijdMaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-maaltijd-onderdeel-dao/index.md)<br>DAO gebruikt voor databank-operaties |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijdOnderdeelToMaaltijd](add-maaltijd-onderdeel-to-maaltijd.md) | `suspend fun addMaaltijdOnderdeelToMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Co-Routine functie voor het toevoegen van een maaltijdOnderdeel aan een maaltijd (JOIN table). Deze thread wordt op de achtergrond uitgevoerd. |
| [deleteMaaltijdenMaaltijdOnderdelenJoin](delete-maaltijden-maaltijd-onderdelen-join.md) | `suspend fun deleteMaaltijdenMaaltijdOnderdelenJoin(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Co-Routine functie voor het verwijderen van alle relaties van een gegeven maaltijd (JOIN table). Deze thread wordt op de achtergrond uitgevoerd. |
| [removeMaaltijdOnderdeelFromMaaltijd](remove-maaltijd-onderdeel-from-maaltijd.md) | `suspend fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Co-Routine functie voor het verwijderen van een maaltijdOnderdeel van een maaltijd (JOIN table). Deze thread wordt op de achtergrond uitgevoerd. |
