package com.example.practiacapipersonas.repositories

import com.example.practicaapipersonas.api.APIProductosService
import com.example.practicaapipersonas.models.Categoria
import com.example.practicaapipersonas.models.Categorias
import com.example.practicaapipersonas.models.Genero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GenderRepository {
    fun getGenderList(success: (Generos?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://apilibreria.jmacboy.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: APIProductosService =
            retrofit.create(APIProductosService::class.java)
        service.getGeneros().enqueue(object : Callback<Generos> {
            override fun onResponse(res: Call<Generos>, response: Response<Generos>) {
                val postList = response.body()
                success(postList)
            }

            override fun onFailure(res: Call<Generos>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun insertGender(
        genero: Genero,
        success: (Genero) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://apilibreria.jmacboy.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: APIProductosService =
            retrofit.create(APIProductosService::class.java)
        service.insertGenero(gender).enqueue(object : Callback<Genero> {
            override fun onResponse(res: Call<Genero>, response: Response<Genero>) {
                val objGender= response.body()
                success(objGender!!)
            }

            override fun onFailure(res: Call<Genero>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getGender(id: Int, success: (Genero?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://apilibreria.jmacboy.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: APIProductosService =
            retrofit.create(APIProductosService::class.java)
        service.getGeneroById(id).enqueue(object : Callback<Genero?> {
            override fun onResponse(res: Call<Genero?>, response: Response<Genero?>) {
                success(response.body())
            }

            override fun onFailure(res: Call<Genero?>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateGender(
        gender: Genero,
        success: (Genero) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://apilibreria.jmacboy.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: APIProductosService =
            retrofit.create(APIProductosService::class.java)
        val genderId = gender.id ?: 0
        service.updateGenero(gender, genderId).enqueue(object : Callback<Genero> {
            override fun onResponse(res: Call<Genero>, response: Response<Genero>) {
                val objGender = response.body()!!
                success(objGender)
            }

            override fun onFailure(res: Call<Genero>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteGender(
        id: Int,
        success: () -> Unit,
        failure: (Throwable) -> Unit
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://apilibreria.jmacboy.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: APIProductosService =
            retrofit.create(APIProductosService::class.java)
        service.deleteGenero(id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                success()
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}