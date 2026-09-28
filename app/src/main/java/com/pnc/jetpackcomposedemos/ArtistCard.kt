package com.pnc.jetpackcomposedemos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pnc.jetpackcomposedemos.ui.theme.JetpackComposeDemosTheme

@Composable
fun ArtistCard(artist: Artist) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = artist.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text("Genre: ${artist.genre}")
            Text("Location: ${artist.location}")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtistCardPreview() {
    val artist = Artist(
        id = 1,
        name = "Artist Name",
        genre = "Genre",
        location = "Location",
        imageUrl = "",
        description = "",
        tags = ""
    )
    JetpackComposeDemosTheme() {
        ArtistCard(
            artist = artist
        )
    }

}