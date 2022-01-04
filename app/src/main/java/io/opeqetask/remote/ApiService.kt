package io.opeqetask.remote
import io.opeqetask.remote.model.UserDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("api")
    suspend fun getUser(
        @Query("results") results : Int =10,
    ): UserDataResponse



}