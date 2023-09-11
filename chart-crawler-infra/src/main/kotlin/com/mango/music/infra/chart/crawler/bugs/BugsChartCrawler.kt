package com.mango.music.infra.chart.crawler.bugs

import com.mango.music.domain.chart.ChartKind
import com.mango.music.domain.chart.Song
import com.mango.music.domain.chart.crawler.ChartCrawler
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class BugsChartCrawler : ChartCrawler {

    override fun crawling(collectDateTime: LocalDateTime): List<Song> {
        val bugGenerator = BugGenerator()
        return bugGenerator.chartElements.map { element ->
            Song.of(
                title = bugGenerator.getSongName(element),
                artist = bugGenerator.getArtistName(element),
                album = bugGenerator.getAlbumName(element),
                rank = bugGenerator.getRank(element),
                imageUrl = bugGenerator.getImageUrl(element),
                kind = ChartKind.BUGS,
                collectDateTime = collectDateTime
            )
        }.toList()
    }

    override fun getKind(): ChartKind {
        return ChartKind.BUGS
    }
}
