package com.vedantjha.realtimecurrencyconverter.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vedantjha.realtimecurrencyconverter.CurrencyConverterApplication
import com.vedantjha.realtimecurrencyconverter.data.network.CurrencyConverterApiService
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterDao
import com.vedantjha.realtimecurrencyconverter.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideBaseUrl(): String {
        return Constant.BASE_URL
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor())
            .build()
    }

    @Provides
    fun authInterceptor(): AuthInterceptor {
        return AuthInterceptor(Constant.API_KEY)
    }

    @Provides
    fun provideRetrofit(
        baseUrl: String,
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesCurrencyConverterApiService(retrofit: Retrofit): CurrencyConverterApiService {
        return retrofit.create(CurrencyConverterApiService::class.java)
    }
}

class AuthInterceptor(val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val requestBuilder = originalRequest.newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer $token")


        val finalRequest = requestBuilder.build()
        return chain.proceed(finalRequest)
    }

}