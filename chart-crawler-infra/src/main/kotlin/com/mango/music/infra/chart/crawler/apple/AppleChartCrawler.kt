package com.mango.music.infra.chart.crawler.apple

import com.mango.music.domain.chart.ChartKind
import com.mango.music.domain.chart.Song
import com.mango.music.domain.chart.crawler.ChartCrawler
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class AppleChartCrawler : ChartCrawler {

    override fun crawling(collectDateTime: LocalDateTime): List<Song> {
        val appleGenerator = AppleGenerator()
        return appleGenerator.chartElements.map { element ->
            Song.of(
                title = appleGenerator.getSongName(element),
                artist = appleGenerator.getArtistName(element),
                album = appleGenerator.getAlbumName(element),
                rank = appleGenerator.getRank(element),
                imageUrl = appleGenerator.getImageUrl(element),
                kind = ChartKind.APPLE_MUSIC,
                collectDateTime = collectDateTime
            )
        }.toList()
    }

    override fun getKind(): ChartKind {
        return ChartKind.APPLE_MUSIC
    }
}