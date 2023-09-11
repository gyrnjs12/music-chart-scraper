package com.mango.music.infra.chart.crawler.melon

import com.mango.music.domain.chart.ChartKind
import com.mango.music.domain.chart.Song
import com.mango.music.domain.chart.crawler.ChartCrawler
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class MelonChartCrawler : ChartCrawler {

    override fun crawling(collectDateTime: LocalDateTime): List<Song> {
        val melonGenerator = MelonGenerator()

        return melonGenerator.chartElements.map { element ->
            Song.of(
                title = melonGenerator.getSongName(element),
                artist = melonGenerator.getArtistName(element),
                album = melonGenerator.getAlbumName(element),
                rank = melonGenerator.getRank(element),
                imageUrl = melonGenerator.getImageUrl(element),
                kind = ChartKind.MELON,
                collectDateTime = collectDateTime
            )
        }.toList()
    }

    override fun getKind(): ChartKind = ChartKind.MELON
}
