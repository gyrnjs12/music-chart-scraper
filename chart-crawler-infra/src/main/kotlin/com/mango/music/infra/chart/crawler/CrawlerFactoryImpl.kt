package com.mango.music.infra.chart.crawler

import com.mango.music.domain.chart.ChartKind
import com.mango.music.domain.chart.crawler.ChartCrawler
import com.mango.music.domain.chart.crawler.CrawlerFactory
import org.springframework.stereotype.Component

@Component
class CrawlerFactoryImpl(
    chartCrawlerSet: Set<ChartCrawler>,
) : CrawlerFactory {

    val crawlerMap = mutableMapOf<ChartKind, ChartCrawler>()

    init {
        chartCrawlerSet.forEach {
            crawlerMap[it.getKind()] = it
        }
    }

    override fun findCrawler(kind: ChartKind): ChartCrawler {
        return crawlerMap[kind] ?: throw IllegalArgumentException("Not found crawler")
    }
}