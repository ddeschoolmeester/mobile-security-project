package com.example.mobsecproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LyricsScreen(modifier: Modifier = Modifier, navController: NavController){
    Column(modifier = modifier) {
        Text(text="Rick Astley - Never Gonna Give You Up", fontSize = 40.sp, lineHeight = 45.sp)
        LazyColumn {
            item { Text(stringResource(R.string.rickroll)) }
            //https://api.lyrics.ovh/v1/Rick%20Astley/Never%20Gonna%20Give%20You%20Up
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navController.navigate("home") }) {
            Text("Back")
        }
    }
}
