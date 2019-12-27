[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [MaaltijdOnderdeelClickableAdapter](index.md) / [onBindViewHolder](./on-bind-view-holder.md)

# onBindViewHolder

`fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Deze functie wordt gebruikt om een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) en [MaaltijdOnderdeelListener](../-maaltijd-onderdeel-listener/index.md) te
binden aan de customViewHolder ([MaaltijdOnderdeelAdapter.ViewHolder](../-maaltijd-onderdeel-adapter/-view-holder/index.md))

### Parameters

`holder` - Custom ViewHolder voor het bijhouden van een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) met [MaaltijdOnderdeelListener](../-maaltijd-onderdeel-listener/index.md)

`position` - Huidige positie in de lijst waar de ViewHolder moet geplaatst worden