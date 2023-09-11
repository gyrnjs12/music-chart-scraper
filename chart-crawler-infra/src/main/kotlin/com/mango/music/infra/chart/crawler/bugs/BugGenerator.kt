package com.mango.music.infra.chart.crawler.bugs

import com.mango.music.domain.chart.ChartKind
import com.mango.music.infra.chart.common.BaseChartCrawler
import org.jsoup.nodes.Element

class BugGenerator : BaseChartCrawler(ChartKind.BUGS) {

    val chartElements = select("div#CHARTrealtime table tbody tr")

    override fun getSongName(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst("p.title a")?.text() ?: "없음"
        }
    }

    override fun getArtistName(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst("p.artist a")?.text() ?: "없음"
        }
    }

    override fun getAlbumName(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst("a.album")?.text() ?: "없음"
        }
    }

    override fun getRank(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst("div.ranking strong")?.text() ?: "없음"
        }
    }

    override fun getImageUrl(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst("img[src^='https://image.bugsm.co.kr/album/']")?.attr("src") ?: "없음"
        }
    }
}