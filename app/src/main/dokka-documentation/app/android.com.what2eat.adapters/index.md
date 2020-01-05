[app](../index.md) / [android.com.what2eat.adapters](./index.md)

## Package android.com.what2eat.adapters

### Types

| Name | Summary |
|---|---|
| [IngredientAdapter](-ingredient-adapter/index.md) | `class IngredientAdapter : ListAdapter<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`ViewHolder`](-ingredient-adapter/-view-holder/index.md)`>`<br>RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor het weergeven van een lijst van ingredienten van een recept. Inclusief een diffCallBack ([MaaltijdDiffCallback](-maaltijd-diff-callback/index.md) voor betere RecyclerView-performantie) |
| [IngredientDiffCallback](-ingredient-diff-callback/index.md) | `class IngredientDiffCallback : ItemCallback<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de ingredienten beter te kunnen uitmaken. |
| [MaaltijdAdapter](-maaltijd-adapter/index.md) | `class MaaltijdAdapter : ListAdapter<`[`Maaltijd`](../android.com.what2eat.model/-maaltijd/index.md)`, `[`ViewHolder`](-maaltijd-adapter/-view-holder/index.md)`>`<br>RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor het weergeven van een lijst van [Maaltijd](../android.com.what2eat.model/-maaltijd/index.md) (inclusief clickListener ([MaaltijdListener](-maaltijd-listener/index.md)]). Inclusief een diffCallBack ([MaaltijdDiffCallback](-maaltijd-diff-callback/index.md) voor betere RecyclerView-performantie) |
| [MaaltijdDiffCallback](-maaltijd-diff-callback/index.md) | `class MaaltijdDiffCallback : ItemCallback<`[`Maaltijd`](../android.com.what2eat.model/-maaltijd/index.md)`>`<br>Deze class verbeterd de performantie in een RecyclerView om verschillen tussen 2 [Maaltijd](../android.com.what2eat.model/-maaltijd/index.md) beter te kunnen uitmaken. |
| [MaaltijdListener](-maaltijd-listener/index.md) | `class MaaltijdListener`<br>Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen. Wanneer de gebruiker op een [Maaltijd](../android.com.what2eat.model/-maaltijd/index.md) clickt in de RecyclerView wordt de id van de [Maaltijd](../android.com.what2eat.model/-maaltijd/index.md) teruggegeven. |
| [MaaltijdOnderdeelAdapter](-maaltijd-onderdeel-adapter/index.md) | `class MaaltijdOnderdeelAdapter : ListAdapter<`[`MaaltijdOnderdeel`](../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`, `[`ViewHolder`](-maaltijd-onderdeel-adapter/-view-holder/index.md)`>`<br>RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor het weergeven van een lijst van [MaaltijdOnderdeel](../android.com.what2eat.model/-maaltijd-onderdeel/index.md) . Inclusief een diffCallBack ([MaaltijdOnderdeelDiffCallback](-maaltijd-onderdeel-diff-callback/index.md) voor betere RecyclerView-performantie) |
| [MaaltijdOnderdeelCheckBoxAdapter](-maaltijd-onderdeel-check-box-adapter/index.md) | `class MaaltijdOnderdeelCheckBoxAdapter : ListAdapter<`[`MaaltijdOnderdeel`](../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`, `[`ViewHolder`](-maaltijd-onderdeel-check-box-adapter/-view-holder/index.md)`>`<br>RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor het weergeven van een lijst van [MaaltijdOnderdeel](../android.com.what2eat.model/-maaltijd-onderdeel/index.md) met een CheckBox (inclusief clickListener ([MaaltijdOnderdeelListener](-maaltijd-onderdeel-listener/index.md)]). Inclusief een diffCallBack ([MaaltijdOnderdeelDiffCallback](-maaltijd-onderdeel-diff-callback/index.md) voor betere RecyclerView-performantie) |
| [MaaltijdOnderdeelClickableAdapter](-maaltijd-onderdeel-clickable-adapter/index.md) | `class MaaltijdOnderdeelClickableAdapter : ListAdapter<`[`MaaltijdOnderdeel`](../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`, `[`ViewHolder`](-maaltijd-onderdeel-clickable-adapter/-view-holder/index.md)`>`<br>RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor het weergeven van een lijst van [MaaltijdOnderdeel](../android.com.what2eat.model/-maaltijd-onderdeel/index.md) (inclusief clickListener ([MaaltijdOnderdeelListener](-maaltijd-onderdeel-listener/index.md)]). Inclusief een diffCallBack ([MaaltijdOnderdeelDiffCallback](-maaltijd-onderdeel-diff-callback/index.md) voor betere RecyclerView-performantie) |
| [MaaltijdOnderdeelDiffCallback](-maaltijd-onderdeel-diff-callback/index.md) | `class MaaltijdOnderdeelDiffCallback : ItemCallback<`[`MaaltijdOnderdeel`](../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>`<br>Deze class verbeterd de performantie in een RecyclerView om verschillen tussen 2 maaltijdOnderdelen beter te kunnen uitmaken. |
| [MaaltijdOnderdeelListener](-maaltijd-onderdeel-listener/index.md) | `class MaaltijdOnderdeelListener`<br>Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen. Wanneer de gebruiker op een [MaaltijdOnderdeel](../android.com.what2eat.model/-maaltijd-onderdeel/index.md) clickt in de RecyclerView wordt de id van het [MaaltijdOnderdeel](../android.com.what2eat.model/-maaltijd-onderdeel/index.md) teruggegeven. |
| [MaaltijdOnderdeelRemoveAdapter](-maaltijd-onderdeel-remove-adapter/index.md) | `class MaaltijdOnderdeelRemoveAdapter : ListAdapter<`[`MaaltijdOnderdeel`](../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`, `[`ViewHolder`](-maaltijd-onderdeel-remove-adapter/-view-holder/index.md)`>`<br>RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor het weergeven van een lijst van [MaaltijdOnderdeel](../android.com.what2eat.model/-maaltijd-onderdeel/index.md) met een verwijder-button (inclusief clickListener ([MaaltijdOnderdeelListener](-maaltijd-onderdeel-listener/index.md)]). Inclusief een diffCallBack ([MaaltijdOnderdeelDiffCallback](-maaltijd-onderdeel-diff-callback/index.md) voor betere RecyclerView-performantie) |
| [RecipeAdapter](-recipe-adapter/index.md) | `class RecipeAdapter : ListAdapter<`[`Recipe`](../android.com.what2eat.network/-recipe/index.md)`, `[`ViewHolder`](-recipe-adapter/-view-holder/index.md)`>`<br>RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor het weergeven van een lijst van [Recipe](../android.com.what2eat.network/-recipe/index.md) (inclusief clickListener ([RecipeListener](-recipe-listener/index.md)]). Inclusief een diffCallBack ([RecipeDiffCallback](-recipe-diff-callback/index.md) voor betere RecyclerView-performantie) |
| [RecipeDiffCallback](-recipe-diff-callback/index.md) | `class RecipeDiffCallback : ItemCallback<`[`Recipe`](../android.com.what2eat.network/-recipe/index.md)`>`<br>Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de [Recipe](../android.com.what2eat.network/-recipe/index.md) beter te kunnen uitmaken. |
| [RecipeListener](-recipe-listener/index.md) | `class RecipeListener`<br>Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen. Wanneer de gebruiker op een [Recipe](../android.com.what2eat.network/-recipe/index.md) clickt in de RecyclerView wordt de [RecipeData](../android.com.what2eat.network/-recipe-data/index.md) teruggegeven. |