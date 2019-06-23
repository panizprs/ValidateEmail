package com.acm.workshop.validateemail.remote.api

import com.acm.workshop.validateemail.remote.api.EmailValidationService.Companion.BASE_URL
import com.acm.workshop.validateemail.remote.dto.IsValidEmail
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface EmailValidationService {

    @GET("{email}")
    fun isValidEmail(
        @Path(value = "email", encoded = true) email : String
    ) : Single<IsValidEmail>

    companion object {
        const val BASE_URL = "https://pozzad-email-validator.p.rapidapi.com/emailvalidator/validateEmail/"

    }
}



fun main(){


    val client = OkHttpClient.Builder()
        .addInterceptor{chain ->
            val request = chain.request()
                .newBuilder()
                .header("X-RapidAPI-Key", "ae638e97aamsheac6412a70e6585p128bc7jsn1cddd14ebab6")
                .build()

            chain.proceed(request)
        }.build()


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()



    val emailValidationService = retrofit.create(EmailValidationService::class.java)

    println(emailValidationService.isValidEmail("john.kl@gmail.com"))

    emailValidationService.isValidEmail("john.kl@gmail.com")
        .subscribe({
            println(it.isValid)
        },{
            println("error: $it")
        })

}