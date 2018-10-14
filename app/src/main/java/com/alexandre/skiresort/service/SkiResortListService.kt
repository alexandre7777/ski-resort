package com.alexandre.skiresort.service

import android.util.Log
import com.alexandre.skiresort.BuildConfig
import com.alexandre.skiresort.model.SkiResort
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val TAG = "SkiResortListService"

/**
 * Get all the ski resort
 */
fun requestSkiResort(
        service: SkiResortListService,
        onSuccess: (skiResorts: List<SkiResort>) -> Unit,
        onError: (error: String) -> Unit) {

    service.getSkiResorts().enqueue(
            object : Callback<List<SkiResort>> {
                override fun onFailure(call: Call<List<SkiResort>>?, t: Throwable) {
                    Log.e(TAG, "fail to get data", t)
                    onError(t.message ?: "unknown error")
                }

                override fun onResponse(
                        call: Call<List<SkiResort>>?,
                        response: Response<List<SkiResort>>
                ) {
                    Log.d(TAG, "got a response $response")
                    if (response.isSuccessful) {
                        val skiResorts = response.body() ?: emptyList()
                        onSuccess(skiResorts)
                    } else {
                        onError(response.errorBody()?.string() ?: "Unknown error")
                    }
                }
            }
    )
}

interface SkiResortListService{

    /**
     * Get ski resort list.
     */
    @GET("v0/b/ski-resort-be7dc.appspot.com/o/resort.json?alt=media&token=3fe8d96d-1d30-47b6-b849-4c5aec831853")
    fun getSkiResorts(): Call<List<SkiResort>>

    companion object {
        private const val BASE_URL = "https://firebasestorage.googleapis.com/"

        fun create(): SkiResortListService {
            val logger = HttpLoggingInterceptor()
            logger.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(SkiResortListService::class.java)
        }
    }
}