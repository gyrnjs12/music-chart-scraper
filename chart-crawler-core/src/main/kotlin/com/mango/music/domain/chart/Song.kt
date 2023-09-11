package com.mango.music.domain.chart

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Song(
    val rank: String,
    val title: String,
    val artist: String,
    val album: String,
    val imageUrl: String,
    @Enumerated(EnumType.STRING)
    val kind: ChartKind,
    val collectDateTime: LocalDateTime,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    companion object {
        fun of(
            rank: String,
            title: String,
            artist: String,
            album: String,
            imageUrl: String,
            kind: ChartKind,
            collectDateTime: LocalDateTime,
        ): Song {
            return Song(rank, title, artist, album, imageUrl, kind, collectDateTime)
        }
    }
}