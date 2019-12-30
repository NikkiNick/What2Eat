[app](../../index.md) / [android.com.what2eat.viewmodels.viewModelFactories](../index.md) / [MaaltijdOnderdeelDetailViewModelFactory](./index.md)

# MaaltijdOnderdeelDetailViewModelFactory

`class MaaltijdOnderdeelDetailViewModelFactory : Factory`

Factory voor het aanmaken van een [MaaltijdOnderdeelDetailViewModel](../../android.com.what2eat.viewmodels/-maaltijd-onderdeel-detail-view-model/index.md). Dit ViewModel wordt aangemaakt met
een gegeven id van een maaltijdOnderdeel.

### Parameters

`maaltijdOnderdeelId` - Id van het gegeven maaltijdOnderdeel

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelDetailViewModelFactory(maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>Factory voor het aanmaken van een [MaaltijdOnderdeelDetailViewModel](../../android.com.what2eat.viewmodels/-maaltijd-onderdeel-detail-view-model/index.md). Dit ViewModel wordt aangemaakt met een gegeven id van een maaltijdOnderdeel. |

### Properties

| Name | Summary |
|---|---|
| [maaltijdOnderdeelId](maaltijd-onderdeel-id.md) | `val maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Id van het gegeven maaltijdOnderdeel |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : ViewModel?> create(modelClass: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<`[`T`](create.md#T)`>): `[`T`](create.md#T)<br>Creëert het [MaaltijdOnderdeelDetailViewModel](../../android.com.what2eat.viewmodels/-maaltijd-onderdeel-detail-view-model/index.md) met gegeven maaltijdOnderdeelId |
