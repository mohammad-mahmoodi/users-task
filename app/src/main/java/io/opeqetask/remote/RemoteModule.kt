package io.opeqetask.remote

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import io.opeqetask.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityRetainedComponent::class)
object RemoteModule {

    @Provides
    @ActivityRetainedScoped
    fun provideApiService(gson: Gson,okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideJson(): Gson {
        return Gson()
    }

    @Provides
    @ActivityRetainedScoped
    fun provideOkHttp(): OkHttpClient {

        val okBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
            okBuilder.addInterceptor(interceptor)
        }

        return okBuilder.build()

    }
}
