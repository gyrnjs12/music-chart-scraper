package com.mango.music.infra.chart.crawler.melon

import com.mango.music.domain.chart.ChartKind
import com.mango.music.domain.chart.crawler.CrawlerFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class MelonChartCrawlerTest @Autowired constructor(
    private val crawlerFactory: CrawlerFactory,
) {

    @Test
    @DisplayName("멜론 차트 크롤링 테스트")
    fun crawlingTest() {
        // given
        val now = LocalDateTime.now()
        val melonChartCrawler = crawlerFactory.findCrawler(ChartKind.MELON)

        // when
        val songs = melonChartCrawler.crawling(now)

        // then
        for (song in songs) {
            println(song.title)
        }
        Assertions.assertEquals(songs.size, 100)
    }
}