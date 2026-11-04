package com.pnc.jetpackcomposedemos.features.artists.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pnc.jetpackcomposedemos.features.artists.domain.Artist
import com.pnc.jetpackcomposedemos.ui.theme.LocalSpacing

@Composable

fun ArtistList (
    artists: List<Artist>,
    onArtistSelected: (Int) -> Unit,
    innerPadding: PaddingValues
) {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    // listState.firstVisibleItemIndex changes on almost every scroll
    // but this boolean only flips twice.
    // derivedStateOf makes readers (subscribers) recompose only when
    // the RESULT changes, not the input
    val showScrollToTop by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.medium)
        ) {
            items(
                items = artists,
                key = { artist -> artist.id }
            ) { artist ->
                ArtistCard(
                    artist = artist,
                    onClick = {
                        onArtistSelected(artist.id)
                    }
                )

            }
        }
    }
}