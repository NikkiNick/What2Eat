[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdDao](index.md) / [getMaaltijdenFromMaaltijdOnderdeel](./get-maaltijden-from-maaltijd-onderdeel.md)

# getMaaltijdenFromMaaltijdOnderdeel

`abstract fun getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?`

Room-database operatie om alle [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) op te halen die een opgegeven maaltijdOnderdeel bevat

### Parameters

`maaltijdOnderdeelId` - Id van maaltijdOnderdeel dat opgevraagd wordt

**Return**
List van [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) die gegeven maaltijdOnderdeel bevatten

