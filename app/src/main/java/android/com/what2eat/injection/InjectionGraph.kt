package android.com.what2eat.injection

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class])
interface InjectionGraph {

    @Component.Builder
    interface Builder {
        fun build(): InjectionGraph
        fun databaseModule(databaseModule: DatabaseModule): Builder
    }

}