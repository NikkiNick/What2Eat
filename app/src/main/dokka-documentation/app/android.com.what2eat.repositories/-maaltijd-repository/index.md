[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdRepository](./index.md)

# MaaltijdRepository

`class MaaltijdRepository`

Repository voor het het uitvoeren van databank-operaties voor [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md)

### Parameters

`maaltijdDbSource` - DAO gebruikt voor databank-operaties

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdRepository(maaltijdDbSource: `[`MaaltijdDao`](../../android.com.what2eat.database/-maaltijd-dao/index.md)`)`<br>Repository voor het het uitvoeren van databank-operaties voor [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) |

### Properties

| Name | Summary |
|---|---|
| [maaltijdDbSource](maaltijd-db-source.md) | `val maaltijdDbSource: `[`MaaltijdDao`](../../android.com.what2eat.database/-maaltijd-dao/index.md)<br>DAO gebruikt voor databank-operaties |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijd](add-maaltijd.md) | `suspend fun addMaaltijd(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Co-Routine functie voor het toevoegen van een maaltijd aan de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [deleteMaaltijd](delete-maaltijd.md) | `suspend fun deleteMaaltijd(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Co-Routine functie voor het verwijderen van een maaltijd van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [getAllMaaltijden](get-all-maaltijden.md) | `suspend fun getAllMaaltijden(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?`<br>Co-Routine functie voor het ophalen van alle maaltijden van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [getMaaltijd](get-maaltijd.md) | `suspend fun getMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`?`<br>Co-Routine functie voor het ophalen van een bepaalde maaltijd van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [getMaaltijdenFromMaaltijdOnderdeel](get-maaltijden-from-maaltijd-onderdeel.md) | `suspend fun getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?`<br>Co-Routine functie voor het ophalen van alle maaltijden die een relatie hebben met een gegeven maaltijdOnderdeel van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [saveMaaltijd](save-maaltijd.md) | `suspend fun saveMaaltijd(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Co-Routine functie voor het aanpassen van een maaltijd van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
