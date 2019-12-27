[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdOnderdeelRepository](./index.md)

# MaaltijdOnderdeelRepository

`class MaaltijdOnderdeelRepository`

Repository voor het het uitvoeren van databank-operaties voor [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)

### Parameters

`maaltijdOnderdeelDbSource` - DAO gebruikt voor databank-operaties

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelRepository(maaltijdOnderdeelDbSource: `[`MaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-onderdeel-dao/index.md)`)`<br>Repository voor het het uitvoeren van databank-operaties voor [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) |

### Properties

| Name | Summary |
|---|---|
| [maaltijdOnderdeelDbSource](maaltijd-onderdeel-db-source.md) | `val maaltijdOnderdeelDbSource: `[`MaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-onderdeel-dao/index.md)<br>DAO gebruikt voor databank-operaties |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijdOnderdeel](add-maaltijd-onderdeel.md) | `suspend fun addMaaltijdOnderdeel(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Co-Routine functie voor het toevoegen van een maaltijdOnderdeel aan de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [deleteMaaltijdOnderdeel](delete-maaltijd-onderdeel.md) | `suspend fun deleteMaaltijdOnderdeel(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Co-Routine functie voor het verwijderen van een maaltijdOnderdeel van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [getAllMaaltijdOnderdelen](get-all-maaltijd-onderdelen.md) | `suspend fun getAllMaaltijdOnderdelen(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`<br>Co-Routine functie voor het ophalen van alle  maaltijdOnderdelen van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [getAllMaaltijdOnderdelenNotFromMaaltijd](get-all-maaltijd-onderdelen-not-from-maaltijd.md) | `suspend fun getAllMaaltijdOnderdelenNotFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`<br>Co-Routine functie voor het ophalen van alle maaltijdOnderdelen die niet bij een gegeven maaltijdOnderdeel horen van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [getMaaltijdOnderdeel](get-maaltijd-onderdeel.md) | `suspend fun getMaaltijdOnderdeel(maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`?`<br>Co-Routine functie voor het ophalen van een bepaalde maaltijdOnderdeel van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [getMaaltijdOnderdelenFromMaaltijd](get-maaltijd-onderdelen-from-maaltijd.md) | `suspend fun getMaaltijdOnderdelenFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`<br>Co-Routine functie voor het ophalen van alle maaltijdOnderdelen van een gegeven maaltijdOnderdeel van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
| [updateMaaltijdOnderdeel](update-maaltijd-onderdeel.md) | `suspend fun updateMaaltijdOnderdeel(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Co-Routine functie voor het aanpassen van een maaltijdOnderdeel aan de Room-databank. Deze thread wordt op de achtergrond uitgevoerd. |
