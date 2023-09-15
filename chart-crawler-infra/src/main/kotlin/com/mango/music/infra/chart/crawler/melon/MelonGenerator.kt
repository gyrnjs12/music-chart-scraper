package com.mango.music.infra.chart.crawler.melon

import com.mango.music.domain.chart.ChartKind
import com.mango.music.infra.chart.common.BaseChartCrawler
import org.jsoup.nodes.Element

class MelonGenerator : BaseChartCrawler(ChartKind.MELON) {

    val chartElements = select(CHART_TABLE_SELECTOR)

    companion object {
        const val CHART_TABLE_SELECTOR: String = "tr.lst50,tr.lst100"
        const val SONG_NAME_SELECTOR: String = "div.wrap_song_info div.ellipsis.rank01 a"
        const val ARTIST_NAME_SELECTOR: String = "div.wrap_song_info div.ellipsis.rank02 a"
        const val ALBUM_NAME_SELECTOR: String = "div.wrap_song_info div.ellipsis.rank03 a"
        const val ALBUM_IMAGE_SELECTOR: String = "img[src^='https://cdnimg.melon.co.kr/']"
        const val RANK_SELECTOR: String = "div.t_center span.rank"
    }

    override fun getSongName(element: Element): String {
        return generateText(element) { el ->
            el.select(SONG_NAME_SELECTOR).first()?.text() ?: "없음"
        }
    }

    override fun getArtistName(element: Element): String {
        return generateText(element) { el ->
            el.select(ARTIST_NAME_SELECTOR).first()?.text() ?: "없음"
        }
    }

    override fun getAlbumName(element: Element): String {
        return generateText(element) { el ->
            el.select(ALBUM_NAME_SELECTOR).first()?.text() ?: "없음"
        }
    }

    override fun getRank(element: Element): String {
        return generateText(element) { el ->
            el.select(RANK_SELECTOR).first()?.text() ?: "없음"

        }
    }

    override fun getImageUrl(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst(ALBUM_IMAGE_SELECTOR)?.attr("src") ?: "없음"
        }
    }

}