[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [MaaltijdAdapter](./index.md)

# MaaltijdAdapter

`class MaaltijdAdapter : ListAdapter<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`, `[`ViewHolder`](-view-holder/index.md)`>`

RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor
het weergeven van een lijst van [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) (inclusief clickListener ([MaaltijdListener](../-maaltijd-listener/index.md)]). Inclusief
een diffCallBack ([MaaltijdDiffCallback](../-maaltijd-diff-callback/index.md) voor betere RecyclerView-performantie)

### Types

| Name | Summary |
|---|---|
| [ViewHolder](-view-holder/index.md) | `class ViewHolder : ViewHolder`<br>Custom ViewHolder class die gebruikt wordt in de RecyclerView. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdAdapter(clickListener: `[`MaaltijdListener`](../-maaltijd-listener/index.md)`)`<br>Constructor voor het aanmaken van een [MaaltijdAdapter](./index.md) (ListAdapter) |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: `[`MaaltijdListener`](../-maaltijd-listener/index.md)<br>ClickListener die gebruikt wordt voor het afhandelen van user-events (onClick) op een [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) in de lijst |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om een [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) en [MaaltijdListener](../-maaltijd-listener/index.md) te binden aan de custom ViewHolder ([MaaltijdAdapter.ViewHolder](-view-holder/index.md)) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: ViewGroup, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewHolder`](-view-holder/index.md)<br>Deze functie wordt gebruikt om de ViewHolder aan te maken. |
