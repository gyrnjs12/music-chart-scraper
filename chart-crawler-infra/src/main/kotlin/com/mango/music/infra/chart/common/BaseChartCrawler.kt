package com.mango.music.infra.chart.common

import com.mango.music.domain.chart.ChartKind
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements


abstract class BaseChartCrawler(
    kind: ChartKind,
) {

    private val document = Jsoup.connect(kind.chartUrl).get()

    fun select(selector: String): Elements = document.select(selector)

    fun generateText(element: Element, generator: (Element) -> String): String {
        return generator(element)
    }

    abstract fun getSongName(element: Element): String
    abstract fun getArtistName(element: Element): String
    abstract fun getAlbumName(element: Element): String
    abstract fun getRank(element: Element): String
    abstract fun getImageUrl(element: Element): String
}