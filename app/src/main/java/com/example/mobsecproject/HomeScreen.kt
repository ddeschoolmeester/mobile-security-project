package com.example.mobsecproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController, dbHandler: DBHandler){
    val songList: List<Song> = dbHandler.readSongs()!!
    Column(modifier = modifier) {
        Text("My Favourite Songs", fontSize = 50.sp, lineHeight = 58.sp)
        Spacer(modifier = Modifier.size(30.dp))
        LazyColumn(modifier = modifier) {
            items(songList) {song ->
                Button(onClick = { navController.navigate("lyrics")}) {
                    Text(song.artist + " - " + song.title)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navController.navigate("add song")}) {
            Text("New Song")
        }
    }
}