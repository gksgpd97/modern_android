package com.example.modernandroid.di

import com.example.modernandroid.model.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
* 모듈은 lazy loading을 지원함
* 안드로이드는 최초 실행 때 빠른 시작을 위해 최적화가 중요한데
* 앱 시작부터 쓰이지 않는 객체들을 미리 올려놓으면 최적화에 좋지 못하기 때문에
* 객체가 최초로 쓰일 때 적재
* */
@Module //앱 최초 실행 시 동작해 메모리에 적재
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton // 왼쪽 아이콘: 메모리에 올라가 있다는 뜻
    fun provideRetrofitInstance(): Retrofit { //리트로핏 객체를 싱글톤 형태로 메모리에 올려놓음, 앱 전역에서 가져다 쓸 수 있음
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton // 가장 왼쪽 아이콘: 메모리에 올라간 객체(리트로핏)를 사용하고 있다는 뜻
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }
}