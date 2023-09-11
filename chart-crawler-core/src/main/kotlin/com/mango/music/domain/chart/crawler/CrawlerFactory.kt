package com.mango.music.domain.chart.crawler

import com.mango.music.domain.chart.ChartKind

fun interface CrawlerFactory {

    fun findCrawler(kind: ChartKind): ChartCrawler
}