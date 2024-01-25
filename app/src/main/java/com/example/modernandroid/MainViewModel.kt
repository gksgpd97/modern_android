package com.example.modernandroid

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernandroid.model.Example
import com.example.modernandroid.model.Movie
import com.example.modernandroid.model.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

//MovieApi가 의존성 주입을 받으면서 AndroidEntryPoint 아래에서 MovieApi가 쓰이는 부분은 연쇄적으로 의존성 주입을 받아야함
//class MainViewModel(private val repository: MovieRepository = MovieRepository()) : ViewModel() {
@HiltViewModel //뷰모델에서 의존성 주입 받으려면 필요함
class MainViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    //ViewModel은 state holder로 Ui와 Model을 분리시킴
    val exampleSampleList = mutableStateOf(
        listOf(
            Example("imageUrl1", "기생충", "두 가정의 만남을 통해 계급 갈등을 그린 영화"),
            Example("imageUrl2", "올드보이", "복수와 비밀을 중심으로 한 스릴러 영화"),
            Example("imageUrl3", "부산행", "좀비 바이러스가 창궐한 기차 안의 생존기를 다룬 영화"),
            Example("imageUrl4", "아가씨", "1930년대 대한민국을 배경으로 한 로맨틱 스릴러"),
            Example("imageUrl5", "괴물", "한강에 나타난 괴물로부터 가족을 구하는 이야기"),
            Example("imageUrl6", "태극기 휘날리며", "한국 전쟁을 배경으로 한 형제의 이야기"),
            Example("imageUrl7", "추격자", "연쇄 살인범을 추격하는 형사의 이야기"),
            Example("imageUrl1", "기생충", "두 가정의 만남을 통해 계급 갈등을 그린 영화"),
            Example("imageUrl2", "올드보이", "복수와 비밀을 중심으로 한 스릴러 영화"),
            Example("imageUrl3", "부산행", "좀비 바이러스가 창궐한 기차 안의 생존기를 다룬 영화"),
            Example("imageUrl4", "아가씨", "1930년대 대한민국을 배경으로 한 로맨틱 스릴러"),
            Example("imageUrl5", "괴물", "한강에 나타난 괴물로부터 가족을 구하는 이야기"),
            Example("imageUrl6", "태극기 휘날리며", "한국 전쟁을 배경으로 한 형제의 이야기"),
            Example("imageUrl7", "추격자", "연쇄 살인범을 추격하는 형사의 이야기"),
            Example("imageUrl1", "기생충", "두 가정의 만남을 통해 계급 갈등을 그린 영화"),
            Example("imageUrl2", "올드보이", "복수와 비밀을 중심으로 한 스릴러 영화"),
            Example("imageUrl3", "부산행", "좀비 바이러스가 창궐한 기차 안의 생존기를 다룬 영화"),
            Example("imageUrl4", "아가씨", "1930년대 대한민국을 배경으로 한 로맨틱 스릴러"),
            Example("imageUrl5", "괴물", "한강에 나타난 괴물로부터 가족을 구하는 이야기"),
            Example("imageUrl6", "태극기 휘날리며", "한국 전쟁을 배경으로 한 형제의 이야기"),
            Example("imageUrl7", "추격자", "연쇄 살인범을 추격하는 형사의 이야기")
        )
    )

    init {
        initNowPlayingMovies()
    }

//    private val _nameState = mutableStateOf("")
//
//    fun changeName(newName: String) {
//        _nameState.value = newName
//    }
    var nameState by mutableStateOf("") // 위처럼 안해도 by키워드를 쓰면 delegation으로 getter setter 지원
        private set

    //1.
    //var nowPlayingMovies: List<Movie> by mutableStateOf(emptyList()) // state값이 변하면 recomposition이 일어나고 화면이 갱신됨

    //2. flow로 쓰는법
    val _state = MutableStateFlow(emptyList<Movie>())
    var nowPlayingMovies = _state.asStateFlow()
    fun initNowPlayingMovies() {
        //외부IO는 비동기식으로 데이터를 받아와야 함
        //내가 기존에 알던 리트로핏 데이터 받아오는 방식은 UI쓰레드가 아니라 별도의 쓰레드에서 구성해야해서 콜백도 많고 복잡했었음
        //지금은 아래처럼 코루틴의 비동기 처리 방식을 이용해서 더 간단하게 할 수 있음
        viewModelScope.launch() {
            try {
                val state = repository.getNowPlayingMovies().results //suspend함수는 반드시 코루틴빌더에서 실행되어야함
                Log.d("MainViewModel", nowPlayingMovies.toString())

                //1.
                //nowPlayingMovies = state //state를 바꾸는 건 메인 쓰레드에서 권장}

                //2. _state를 업데이트하면
                _state.value = state
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
