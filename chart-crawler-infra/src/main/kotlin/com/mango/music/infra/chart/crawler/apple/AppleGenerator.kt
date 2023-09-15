package com.mango.music.infra.chart.crawler.apple

import com.mango.music.domain.chart.ChartKind
import com.mango.music.infra.chart.common.BaseChartCrawler
import org.jsoup.nodes.Element

class AppleGenerator : BaseChartCrawler(ChartKind.APPLE_MUSIC) {

    val chartElements = select(CHART_TABLE_SELECTOR)

    companion object {
        const val CHART_TABLE_SELECTOR: String = "div.songs-list div.songs-list-row"
        const val SONG_NAME_SELECTOR: String = "div.songs-list-row__song-name"
        const val ARTIST_NAME_SELECTOR: String = ".songs-list-row__by-line a"
        const val ALBUM_NAME_SELECTOR: String = ".songs-list__col.songs-list__col--tertiary span a"
        const val RANK_SELECTOR: String = ".songs-list-row__rank"
        const val ALBUM_IMAGE_SELECTOR: String = ".songs-list-row__artwork-wrapper source"
    }

    override fun getSongName(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst(SONG_NAME_SELECTOR)?.text() ?: "없음"
        }
    }

    override fun getArtistName(element: Element): String {
        return generateText(element) { el ->
            el.select(ARTIST_NAME_SELECTOR).map { it.text() }.joinToString { it }
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
            el.select(ALBUM_IMAGE_SELECTOR).first()
                ?.attr("srcset")
                ?.split("40w")
                ?.get(0)
                ?: "없음"
        }
    }
}