[app](../../index.md) / [android.com.what2eat.injection](../index.md) / [NetworkModule](./index.md)

# NetworkModule

`@Module class NetworkModule`

Network Module voor Dagger dependency injection

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkModule()`<br>Network Module voor Dagger dependency injection |

### Functions

| Name | Summary |
|---|---|
| [provideRecipeApi](provide-recipe-api.md) | `fun provideRecipeApi(retrofit: Retrofit): `[`RecipeApi`](../../android.com.what2eat.network/-recipe-api/index.md)<br>Voorzien van RecipeApi singleton |
| [provideRecipeApiRepository](provide-recipe-api-repository.md) | `fun provideRecipeApiRepository(recipeApi: `[`RecipeApi`](../../android.com.what2eat.network/-recipe-api/index.md)`): `[`RecipeApiRepository`](../../android.com.what2eat.repositories/-recipe-api-repository/index.md)<br>Voorzien van RecipeApiRepository singleton |
| [provideRetrofitInterface](provide-retrofit-interface.md) | `fun provideRetrofitInterface(): Retrofit`<br>Voorzien van Retrofit singleton |
