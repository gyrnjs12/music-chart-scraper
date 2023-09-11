package com.mango.music.infra.chart.crawler

import com.mango.music.domain.chart.ChartKind
import com.mango.music.domain.chart.crawler.CrawlerFactory
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CrawlerFactoryTest @Autowired constructor(
    private val crawlerFactory: CrawlerFactory,
) {

    @Test
    @DisplayName("올바른 종류의 크롤러가 반환된다.")
    fun findCrawlerTest() {

        // given
        val crawlerKind = ChartKind.APPLE_MUSIC

        // when
        val crawler = crawlerFactory.findCrawler(crawlerKind)

        // then
        assertThat(crawler.getKind()).isEqualTo(crawlerKind)
    }
}