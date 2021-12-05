package com.ifk8edvmat1gabkojginkir.ktuprojektas

import retrofit2.Retrofit
import com.ifk8edvmat1gabkojginkir.ktuprojektas.RetrofitClientInstance
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    private const val BASE_URL =
        "https://itoaze.lt:4443/"  // getquizservice ten galas linko uzrasyti tinkamai
    private val client = OkHttpClient.Builder().build()
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            }
            return retrofit
        }

    fun<T> buildService(service: Class<T>): T? {
        return retrofitInstance?.create(service)
    }
}


