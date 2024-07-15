package com.example.mobsecproject

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController

@Composable
fun AddSongScreen(modifier: Modifier = Modifier, navController: NavController, dbHandler: DBHandler){

    Column(modifier = modifier) {
        val songTitle = remember { mutableStateOf(TextFieldValue()) }
        val artist  = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            label = { Text("Song") },
            value = songTitle.value,
            onValueChange = { songTitle.value = it }
        )
        TextField(
            label = { Text("Artist") },
            value = artist.value,
            onValueChange = { artist.value = it },
        )
        Button(onClick = {
            dbHandler.addNewSong(songTitle.value.text , artist.value.text)
            navController.navigate("home")
        }) {
            Text(text = "Add Song")
        }
    }
}