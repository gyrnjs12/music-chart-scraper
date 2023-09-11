package com.mango.music.domain.chart

import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository : JpaRepository<Song, Long> {
}