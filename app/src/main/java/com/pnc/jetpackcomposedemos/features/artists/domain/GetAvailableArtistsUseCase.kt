package com.pnc.jetpackcomposedemos.features.artists.domain

import com.pnc.jetpackcomposedemos.features.artists.data.DefaultArtistRepository

class GetAvailableArtistsUseCase(
    private val artistRepository: ArtistRepository = DefaultArtistRepository()
) {
    suspend operator fun invoke(): List<Artist> {
        return artistRepository
            .getArtists()
            .filter { it.isAvailable }
            .sortedBy { it.name }
    }
}