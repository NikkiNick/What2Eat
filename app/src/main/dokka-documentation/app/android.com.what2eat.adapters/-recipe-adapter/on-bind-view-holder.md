[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [RecipeAdapter](index.md) / [onBindViewHolder](./on-bind-view-holder.md)

# onBindViewHolder

`fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Deze functie wordt gebruikt om een [Recipe](../../android.com.what2eat.network/-recipe/index.md) en [RecipeListener](../-recipe-listener/index.md) te binden aan de custom
ViewHolder ([RecipeAdapter.ViewHolder](-view-holder/index.md))

### Parameters

`holder` - Custom ViewHolder voor het bijhouden van een [Recipe](../../android.com.what2eat.network/-recipe/index.md) met [RecipeListener](../-recipe-listener/index.md)

`position` - Huidige positie in de lijst waar de ViewHolder moet geplaatst worden