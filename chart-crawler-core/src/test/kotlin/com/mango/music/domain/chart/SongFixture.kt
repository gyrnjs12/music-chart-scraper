package com.mango.music.domain.chart

import java.time.LocalDateTime

class SongFixture {

    companion object {
        fun fixture(title: String = "title"): Song {
            return Song(
                title = title,
                rank = "test",
                artist = "test",
                album = "test",
                imageUrl = "test",
                kind = ChartKind.APPLE_MUSIC,
                collectDateTime = LocalDateTime.now()
            )
        }
    }
}