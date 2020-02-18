package com.example.githubapp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService{
    @GET("/users/{nome}")
    fun Obter(@Path("nome") nomeUsuario: String) : Call<Usuario>
}