package com.example.modernandroid.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

//만약 의존성 주입을 안쓰고 아래처럼 생성자에 파라미터를 두었으면 에러남. 에러 해결을 위해 객체 생성을 디폴트 값으로 해줬어야했음
//근데 의존성 주입으로 MovieApi 객체를 미리 생성해놔서 아래처럼 사용가능하게 됨
class MovieRepository @Inject constructor(private val movieApi: MovieApi) {

    suspend fun getNowPlayingMovies(): MovieResponse {
        return movieApi.getNowPlayingMovies()
    }
}