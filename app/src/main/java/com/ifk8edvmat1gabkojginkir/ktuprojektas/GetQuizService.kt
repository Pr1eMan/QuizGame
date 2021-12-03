package com.ifk8edvmat1gabkojginkir.ktuprojektas

import com.ifk8edvmat1gabkojginkir.ktuprojektas.DTO.quizList
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface GetQuizApiEndpointInterface {
    @GET("quiz") // realiai veikia betkur pasikreipus (tas servisas nlb turi endpointu?)
    fun getAllQuiz(@Query("topic") topic: String, @Query("formatas") format: String): Call<quizList>
}


