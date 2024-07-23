package com.example.mobsecproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

@Composable
fun LyricsScreen(modifier: Modifier = Modifier, navController: NavController, artist:String = "Rick Astley", title: String = "Never Gonna Give You Up"){
    var lyrics by remember { mutableStateOf<String>(R.string.rickroll.toString())}
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            lyrics = getLyrics(artist,title)
        }
    }

    Column(modifier = modifier) {
        Text(text="$artist - $title", fontSize = 40.sp, lineHeight = 45.sp)
        LazyColumn {
            item { Text(lyrics) }
            //https://api.lyrics.ovh/v1/Rick%20Astley/Never%20Gonna%20Give%20You%20Up
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navController.navigate("home") }) {
            Text("Back")
        }
    }
}

suspend fun getLyrics(artist: String, title: String): String {
    val client = OkHttpClient()
    val url = HttpUrl.Builder()
        .scheme("https")
        .host("api.lyrics.ovh")
        .addEncodedPathSegments("v1/$artist/$title")
        .build()
    val request = Request.Builder()
        .url(url)
        .build()

    return withContext(Dispatchers.IO){
        client.newCall(request).execute().use { response ->
            val resposebody = response.body?.string()
            val jsonObject = JSONObject(resposebody ?: "")
            jsonObject.getString("lyrics")
        }
    }

}
