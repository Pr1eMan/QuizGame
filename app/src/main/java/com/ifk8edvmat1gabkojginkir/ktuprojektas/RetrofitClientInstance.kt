package com.ifk8edvmat1gabkojginkir.ktuprojektas

import retrofit2.Retrofit
import com.ifk8edvmat1gabkojginkir.ktuprojektas.RetrofitClientInstance
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    private const val BASE_URL =
        "http://itoaze.lt:8000/"  // getquizservice ten galas linko uzrasyti tinkamai
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
}


