package com.mango.music.domain.chart.crawler

import com.mango.music.domain.chart.ChartKind
import com.mango.music.domain.chart.Song
import java.time.LocalDateTime

interface ChartCrawler {

    fun crawling(collectDateTime: LocalDateTime): List<Song>

    fun getKind(): ChartKind
}