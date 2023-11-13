package com.example.geeksandroid6.di

import com.example.geeksandroid6.BuildConfig
import com.example.geeksandroid6.data.client.YouTubeApiService
import com.example.geeksandroid6.data.repo.YouTubeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object YouTubeModule {

    @Singleton
    @Provides
    fun provideYouTubeApiService(
        retrofit: Retrofit
    ) : YouTubeApiService = retrofit.create(YouTubeApiService::class.java)

    @Singleton
    @Provides
    fun provideRetrofitClient(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor
    ) : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Singleton
    @Provides
    fun provideYouTubeRepo(
        apiService: YouTubeApiService
    ) = YouTubeRepo(apiService)
}