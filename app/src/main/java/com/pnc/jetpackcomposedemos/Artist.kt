package com.pnc.jetpackcomposedemos

data class Artist (
    val id: Int,
    val name: String,
    val genre: String,
    val location: String,
    val imageUrl: String,
    val description: String,
    val tags: String
) {
    companion object {
        fun generateArtists(num: Int): List<Artist> = List(num) { index ->
            Artist(
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
