package com.example.mobsecproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobsecproject.ui.theme.MobsecprojectTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobsecprojectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FavouriteSongApp()
                }
            }
        }
    }
}


@Composable
fun FavouriteSongApp() {
    val navController = rememberNavController()
    val dbHandler = DBHandler(LocalContext.current)

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController, dbHandler = dbHandler) }
        composable("lyrics") { LyricsScreen(navController = navController) }
        composable("add song") { AddSongScreen(navController = navController, dbHandler = dbHandler) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobsecprojectTheme {
        FavouriteSongApp()
    }
}