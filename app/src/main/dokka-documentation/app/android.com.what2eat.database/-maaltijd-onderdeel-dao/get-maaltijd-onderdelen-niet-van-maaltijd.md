[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdOnderdeelDao](index.md) / [getMaaltijdOnderdelenNietVanMaaltijd](./get-maaltijd-onderdelen-niet-van-maaltijd.md)

# getMaaltijdOnderdelenNietVanMaaltijd

`abstract fun getMaaltijdOnderdelenNietVanMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`

Room-database om alle [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) op te halen die bij niet een opgegeven [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) horen

### Parameters

`maaltijdId` - Id van gegeven [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md)

**Return**
List van [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)

