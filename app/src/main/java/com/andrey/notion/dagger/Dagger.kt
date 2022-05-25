package com.andrey.notion.dagger

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andrey.notion.Fragments.Auth.AuthFragment
import com.andrey.notion.Fragments.Auth.AuthViewModel
import com.andrey.notion.api.auth.*
import com.andrey.notion.MainApplication
import com.andrey.notion.api.auth.music.MusicService
import com.andrey.notion.api.auth.music.MusicServiceRepository
import com.andrey.notion.dagger.MyViewModelFactory
import com.andrey.notion.dagger.ViewModelKey
import com.google.gson.GsonBuilder
import dagger.*
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.*

@Singleton
@Component(modules = [AppModule::class, AppBindsModule::class, FragmentModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(mainApplication: MainApplication)
    //fun inject(authFragment: AuthFragment)

    fun viewModelsFactory(): ViewModelFactory

    fun getAuthRepo(): AuthServiceRepository

    fun getMusicRepo(): MusicServiceRepository
}

@Module
class AppModule {

    @Singleton
    @Provides
    @Named("auth")
    fun provideRetrofitMusicLibrary(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://musiclibrary-susie.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    @Named("music")
    fun provideRetrofitBilling(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://musiclibrary-susie.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            //.addInterceptor(RequestInterceptor())
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    @Singleton
    @Provides
    fun provideBillingServerService(@Named("auth") retrofit: Retrofit): AuthService {
        return retrofit
            .create(AuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideMusicServerService(@Named("music") retrofit:Retrofit):MusicService{
        return retrofit.create(MusicService::class.java)
    }

//    @Singleton
//    @Provides
//    fun provideContextProviders(): ContextProviders {
//        return ContextProviders()
//    }

}

@Module
abstract class AppBindsModule {

    @Binds
    @[IntoMap ViewModelKey(AuthViewModel::class)]
    internal abstract fun provideAuthViewModel(mainViewModel: AuthViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory
}

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): AuthFragment
}

class ViewModelFactory @Inject constructor(
    authViewModelProvider: Provider<AuthViewModel>,
    //mainViewModel: Provider<MainViewModel>
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        AuthViewModel::class.java to authViewModelProvider,
      //  MainViewModel::class.java to mainViewModel
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}

fun Fragment.getAppComponent(): ApplicationComponent = (context?.applicationContext as MainApplication).appComponent