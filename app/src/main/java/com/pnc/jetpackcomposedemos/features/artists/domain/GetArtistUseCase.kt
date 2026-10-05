package com.pnc.jetpackcomposedemos.features.artists.domain

import com.pnc.jetpackcomposedemos.features.artists.data.DefaultArtistRepository

class GetArtistUseCase(
    private val artistRepository: ArtistRepository = DefaultArtistRepository()
) {
    suspend operator fun invoke(id: Int): Artist? {
        return artistRepository.getArtist(id)
    }

}