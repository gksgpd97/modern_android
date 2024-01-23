package com.example.modernandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.modernandroid.model.Movie
import com.example.modernandroid.ui.theme.ModernAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieScreen()
            //practiceUi()
        }
    }

    @Composable
    fun MovieScreen() {
        ModernAndroidTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                MovieList()
            }
        }
    }

    @Composable
    fun MovieList() {
        val mainViewModel = viewModel<MainViewModel>() //뷰모델은 내부적으로 싱글톤으로 객체 생성 됨
        LazyColumn {
            items(mainViewModel.movieSampleList.value) {
                MovieItem(it)
            }
        }
    }

    @Composable
    fun MovieItem(movie: Movie) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            modifier = Modifier
                .padding(4.dp)
                .wrapContentHeight()
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Row() {
                Image(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.size(20.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
                    Text(text = movie.description, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun PreviewMovieScreen() {
        MovieScreen()
    }

    //@Preview()//파라미터로 옵션 넣을 수 있음
    @Composable
    fun practiceUi() {
        //레이아웃 배치 방법은 행과 열, 박스 세 가지
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, //트레일링콤마: 마지막 파라미터에도 콤마 쓸 수 있는 컨벤션
        ) {
            text()
            button()
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            imagePainter()
            imageVector()
        }

    }

    @Composable
    fun text() {
        Text("Hello", fontSize = 20.sp, color = Color.Red) //컴포저블 함수는 대문자로 시작하는 게 컨벤션
    }

    @Composable
    fun button() {
        Button(
            onClick = { /*TODO*/ },
            // content = {Text("Button")} 트레일링람다: 가장 마지막에 오는 람다식은 함수 파라미터 안 말고 밖에도 정의할 수 있음
        ) {
            Text("Button")
        }
    }

    @Composable
    fun imagePainter() {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
    }

    @Composable
    fun imageVector() {
        Image(
            imageVector = Icons.Rounded.Person,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .background(Color.DarkGray)
                .padding(24.dp, 24.dp)
        )
        //공통적인 속성은 Modifier에 정의되어 있음
        //padding을 가장 먼저 정의하면 마진이 되고 그 이후는 패딩이 됨. 이 무슨..?
        Icon(imageVector = Icons.Rounded.Info, contentDescription = null) // 비슷한 함수
    }
}

