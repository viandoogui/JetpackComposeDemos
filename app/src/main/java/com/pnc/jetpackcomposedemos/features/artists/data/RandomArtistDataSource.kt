package com.pnc.jetpackcomposedemos.features.artists.data

class RandomArtistDataSource : ArtistDataSource {

    override suspend fun getArtists(): List<ArtistDto> {
        return List(100) { index ->
            ArtistDto(
                id = index + 1,
                name = "Artist ${index + 1}",
                genre = listOf("Rock", "Pop", "Jazz", "Acoustic", "Classical").random(),
                location = listOf("New York", "Los Angeles", "Chicago").random(),
                imageUrl = "/images/fakeimage.jpg",
                description = "Some fake details",
                tags = "tags,tags,tags"

            )

        }
    }

}