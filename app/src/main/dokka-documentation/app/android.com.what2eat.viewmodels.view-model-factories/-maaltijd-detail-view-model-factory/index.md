[app](../../index.md) / [android.com.what2eat.viewmodels.viewModelFactories](../index.md) / [MaaltijdDetailViewModelFactory](./index.md)

# MaaltijdDetailViewModelFactory

`class MaaltijdDetailViewModelFactory : Factory`

Factory voor het aanmaken van een [MaaltijdDetailViewModel](../../android.com.what2eat.viewmodels/-maaltijd-detail-view-model/index.md). Dit ViewModel wordt aangemaakt met
een gegeven id van een maaltijd.

### Parameters

`maaltijdId` - Id van de gegeven maaltijd

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdDetailViewModelFactory(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>Factory voor het aanmaken van een [MaaltijdDetailViewModel](../../android.com.what2eat.viewmodels/-maaltijd-detail-view-model/index.md). Dit ViewModel wordt aangemaakt met een gegeven id van een maaltijd. |

### Properties

| Name | Summary |
|---|---|
| [maaltijdId](maaltijd-id.md) | `val maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Id van de gegeven maaltijd |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : ViewModel?> create(modelClass: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<`[`T`](create.md#T)`>): `[`T`](create.md#T)<br>Creëert het [MaaltijdDetailViewModel](../../android.com.what2eat.viewmodels/-maaltijd-detail-view-model/index.md) met gegeven maaltijdId |
