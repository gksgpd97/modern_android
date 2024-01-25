package com.example.modernandroid

sealed class Screen (val route: String) {
    data object Home: Screen("home") // object 키워드를 쓰면 싱글톤으로 생성
    data object Second: Screen("second") // data object는 객체 기본 3개 메서드가 기본 탑재되어있음
    data object Last: Screen("last")
}