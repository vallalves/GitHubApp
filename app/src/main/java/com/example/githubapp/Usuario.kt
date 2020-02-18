package com.example.githubapp

import com.google.gson.annotations.SerializedName


class Usuario(
    @SerializedName("name") internal var nome: String,
    @SerializedName("avatar_url") var  avatarUrl: String
)
