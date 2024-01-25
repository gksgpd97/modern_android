package com.example.modernandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.modernandroid.model.Example
import com.example.modernandroid.model.Movie
import com.example.modernandroid.ui.theme.ModernAndroidTheme

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Button(
            modifier = Modifier
                .width(50.dp)
                .height(20.dp),
            onClick = { navController.navigate(Screen.Second.route + "/hyewon han") }) {
            Text(text = "")
        }
        Spacer(modifier = Modifier.size(10.dp))
        MovieList()
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
    //val mainViewModel = viewModel<MainViewModel>() //뷰모델은 내부적으로 싱글톤으로 객체 생성 됨
    val mainViewModel = hiltViewModel<MainViewModel>() //의존성주입된 뷰모델은 hilt가 지원하는 뷰모델 써야함
    val movies = mainViewModel.nowPlayingMovies.collectAsState().value
    LazyColumn {
        //1.
//        items(mainViewModel.nowPlayingMovies) {
//            MovieItem(it)
//        }

        //2. 이쒸 수업 얼레벌레 끝나서 못고침
        items(movies){
            MovieItem(movie = it)
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
                Text(text = movie.overview, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}