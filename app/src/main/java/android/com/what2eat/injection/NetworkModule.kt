package android.com.what2eat.injection

import android.com.what2eat.network.RecipeApi
import android.com.what2eat.utils.EDAMAM_BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideRecipeApi(retrofit: Retrofit): RecipeApi {
        return retrofit.create(RecipeApi::class.java)
    }

    @Singleton
    @Provides
    internal fun provideRetrofitInterface(): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(EDAMAM_BASE_URL)
            .build()


    }

}