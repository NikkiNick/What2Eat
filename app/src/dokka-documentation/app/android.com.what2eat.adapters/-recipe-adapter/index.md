[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [RecipeAdapter](./index.md)

# RecipeAdapter

`class RecipeAdapter : ListAdapter<`[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`, `[`ViewHolder`](-view-holder/index.md)`>`

RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor
het weergeven van een lijst van [Recipe](../../android.com.what2eat.network/-recipe/index.md) (inclusief clickListener ([RecipeListener](../-recipe-listener/index.md)]). Inclusief
een diffCallBack ([RecipeDiffCallback](../-recipe-diff-callback/index.md) voor betere RecyclerView-performantie)

### Types

| Name | Summary |
|---|---|
| [ViewHolder](-view-holder/index.md) | `class ViewHolder : ViewHolder`<br>Custom ViewHolder class die gebruikt wordt in de RecyclerView. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeAdapter(clickListener: `[`RecipeListener`](../-recipe-listener/index.md)`)`<br>Constructor voor het aanmaken van een [RecipeAdapter](./index.md) (ListAdapter) |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: `[`RecipeListener`](../-recipe-listener/index.md)<br>ClickListener die gebruikt wordt voor het afhandelen van user-events (onClick) op een [Recipe](../../android.com.what2eat.network/-recipe/index.md) in de lijst |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om een [Recipe](../../android.com.what2eat.network/-recipe/index.md) en [RecipeListener](../-recipe-listener/index.md) te binden aan de custom ViewHolder ([RecipeAdapter.ViewHolder](-view-holder/index.md)) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewHolder`](-view-holder/index.md)<br>Deze functie wordt gebruikt om de ViewHolder aan te maken. |
