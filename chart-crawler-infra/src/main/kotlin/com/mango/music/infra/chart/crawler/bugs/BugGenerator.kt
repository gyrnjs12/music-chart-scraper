package com.mango.music.infra.chart.crawler.bugs

import com.mango.music.domain.chart.ChartKind
import com.mango.music.infra.chart.common.BaseChartCrawler
import org.jsoup.nodes.Element

class BugGenerator : BaseChartCrawler(ChartKind.BUGS) {

    val chartElements = select(CHART_TABLE_SELECTOR)

    companion object {
        const val CHART_TABLE_SELECTOR: String = "div#CHARTrealtime table tbody tr"
        const val SONG_NAME_SELECTOR: String = "p.title a"
        const val ARTIST_NAME_SELECTOR: String = "p.artist a"
        const val ALBUM_NAME_SELECTOR: String = "a.album"
        const val ALBUM_IMAGE_SELECTOR: String = "img[src^='https://image.bugsm.co.kr/album/']"
        const val RANK_SELECTOR: String = "div.ranking strong"
    }

    override fun getSongName(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst(SONG_NAME_SELECTOR)?.text() ?: "없음"
        }
    }

    override fun getArtistName(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst(ARTIST_NAME_SELECTOR)?.text() ?: "없음"
        }
    }

    override fun getAlbumName(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst(ALBUM_NAME_SELECTOR)?.text() ?: "없음"
        }
    }

    override fun getRank(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst(RANK_SELECTOR)?.text() ?: "없음"
        }
    }

    override fun getImageUrl(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst(ALBUM_IMAGE_SELECTOR)?.attr("src") ?: "없음"
        }
    }
}