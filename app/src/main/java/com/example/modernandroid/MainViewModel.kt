package com.example.modernandroid

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.modernandroid.model.Movie

class MainViewModel:ViewModel() {
    //ViewModel은 state holder로 Ui와 Model을 분리시킴
    val movieSampleList = mutableStateOf(
        listOf(
            Movie("imageUrl1", "기생충", "두 가정의 만남을 통해 계급 갈등을 그린 영화"),
            Movie("imageUrl2", "올드보이", "복수와 비밀을 중심으로 한 스릴러 영화"),
            Movie("imageUrl3", "부산행", "좀비 바이러스가 창궐한 기차 안의 생존기를 다룬 영화"),
            Movie("imageUrl4", "아가씨", "1930년대 대한민국을 배경으로 한 로맨틱 스릴러"),
            Movie("imageUrl5", "괴물", "한강에 나타난 괴물로부터 가족을 구하는 이야기"),
            Movie("imageUrl6", "태극기 휘날리며", "한국 전쟁을 배경으로 한 형제의 이야기"),
            Movie("imageUrl7", "추격자", "연쇄 살인범을 추격하는 형사의 이야기"),
            Movie("imageUrl1", "기생충", "두 가정의 만남을 통해 계급 갈등을 그린 영화"),
            Movie("imageUrl2", "올드보이", "복수와 비밀을 중심으로 한 스릴러 영화"),
            Movie("imageUrl3", "부산행", "좀비 바이러스가 창궐한 기차 안의 생존기를 다룬 영화"),
            Movie("imageUrl4", "아가씨", "1930년대 대한민국을 배경으로 한 로맨틱 스릴러"),
            Movie("imageUrl5", "괴물", "한강에 나타난 괴물로부터 가족을 구하는 이야기"),
            Movie("imageUrl6", "태극기 휘날리며", "한국 전쟁을 배경으로 한 형제의 이야기"),
            Movie("imageUrl7", "추격자", "연쇄 살인범을 추격하는 형사의 이야기"),
            Movie("imageUrl1", "기생충", "두 가정의 만남을 통해 계급 갈등을 그린 영화"),
            Movie("imageUrl2", "올드보이", "복수와 비밀을 중심으로 한 스릴러 영화"),
            Movie("imageUrl3", "부산행", "좀비 바이러스가 창궐한 기차 안의 생존기를 다룬 영화"),
            Movie("imageUrl4", "아가씨", "1930년대 대한민국을 배경으로 한 로맨틱 스릴러"),
            Movie("imageUrl5", "괴물", "한강에 나타난 괴물로부터 가족을 구하는 이야기"),
            Movie("imageUrl6", "태극기 휘날리며", "한국 전쟁을 배경으로 한 형제의 이야기"),
            Movie("imageUrl7", "추격자", "연쇄 살인범을 추격하는 형사의 이야기")

        )
    )
}