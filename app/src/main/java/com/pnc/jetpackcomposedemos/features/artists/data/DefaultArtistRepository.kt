package com.pnc.jetpackcomposedemos.features.artists.data

import com.pnc.jetpackcomposedemos.features.artists.domain.Artist
import com.pnc.jetpackcomposedemos.features.artists.domain.ArtistRepository

class DefaultArtistRepository(
    private val dataSource: ArtistDataSource = HardCodedArtistDataSource()
): ArtistRepository {
    override suspend fun getArtists(): List<Artist> {
        return dataSource.getArtists().map{ artistDto ->
            ArtistMapper.mapToDomain(artistDto)
        }
    }

    override suspend fun getArtist(id: Int): Artist? {
        return getArtists()
            .firstOrNull {
                it.id == id
            }
    }
}