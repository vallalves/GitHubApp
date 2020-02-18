package com.example.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSearch.setOnClickListener {
            buscar()

        }

        carregarImagem("data:image/png;base64,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")
    }

    private fun carregarImagem(url: String){
        Picasso.get()
            .load(url)
            .into(ivUser)
    }

    private fun buscar()
    {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)
            service.Obter(etUsername.text.toString())
                .enqueue(object : Callback<Usuario>{
                    override fun onFailure(call: Call<Usuario>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                            if(response.isSuccessful){
                                var usuario = response.body()
                                tvUser.text = usuario?.nome
                            }else{
                                tvUser.text = "Erro ao buscar o usuário"
                            }
                    }
                })

    }
}
