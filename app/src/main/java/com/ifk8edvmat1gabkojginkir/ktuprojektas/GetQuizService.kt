package com.ifk8edvmat1gabkojginkir.ktuprojektas

import com.ifk8edvmat1gabkojginkir.ktuprojektas.DTO.quizList
import retrofit2.Call
import retrofit2.http.GET

interface GetQuizService {
    @GET("?topic=Vilnius&formatas=json") //cia uzrasyti reikia kas eina po localhost:8000/....
    fun getallquiz() : Call<quizList>
}


