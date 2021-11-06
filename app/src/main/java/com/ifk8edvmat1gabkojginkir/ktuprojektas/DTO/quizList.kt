package com.ifk8edvmat1gabkojginkir.ktuprojektas.DTO

import com.google.gson.annotations.SerializedName

data class quizList(@SerializedName("quiz") var quiz:List<quizDTO>) {

}