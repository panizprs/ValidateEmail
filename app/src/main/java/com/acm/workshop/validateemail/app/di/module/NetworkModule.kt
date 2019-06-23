package com.acm.workshop.validateemail.app.di.module

import com.acm.workshop.validateemail.remote.api.EmailValidationService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule{

    @Provides
    fun provideEmailValidationService(retrofit : Retrofit) =
        retrofit.create(EmailValidationService::class.java)


    @Provides
    fun provideOKHttpClient() = OkHttpClient.Builder()
        .addInterceptor{chain ->
            val request = chain.request()
                .newBuilder()
                .header("X-RapidAPI-Key", "ae638e97aamsheac6412a70e6585p128bc7jsn1cddd14ebab6")
                .build()

            chain.proceed(request)
        }.build()

    @Provides
    fun provideRetrofit(client : OkHttpClient) = Retrofit.Builder()
        .baseUrl(EmailValidationService.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

}