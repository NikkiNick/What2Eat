[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [MaaltijdOnderdeelAdapter](./index.md)

# MaaltijdOnderdeelAdapter

`class MaaltijdOnderdeelAdapter : ListAdapter<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`, `[`ViewHolder`](-view-holder/index.md)`>`

RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor
het weergeven van een lijst van [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) . Inclusief een diffCallBack
([MaaltijdOnderdeelDiffCallback](../-maaltijd-onderdeel-diff-callback/index.md) voor betere RecyclerView-performantie)

### Types

| Name | Summary |
|---|---|
| [ViewHolder](-view-holder/index.md) | `class ViewHolder : ViewHolder`<br>Custom ViewHolder class die gebruikt wordt in de RecyclerView. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelAdapter()`<br>Constructor voor het aanmaken van een [MaaltijdOnderdeelAdapter](./index.md) (ListAdapter) |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) te binden aan de custom ViewHolder ([MaaltijdOnderdeelAdapter.ViewHolder](-view-holder/index.md)) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: ViewGroup, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewHolder`](-view-holder/index.md)<br>Deze functie wordt gebruikt om de ViewHolder aan te maken. |
