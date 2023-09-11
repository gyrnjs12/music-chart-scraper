package com.mango.music.infra.chart.crawler.apple

import com.mango.music.domain.chart.ChartKind
import com.mango.music.infra.chart.common.BaseChartCrawler
import org.jsoup.nodes.Element

class AppleGenerator : BaseChartCrawler(ChartKind.APPLE_MUSIC) {

    val chartElements = select("div.songs-list div.songs-list-row")

    override fun getSongName(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst("div.songs-list-row__song-name")?.text() ?: "없음"
        }
    }

    override fun getArtistName(element: Element): String {
        return generateText(element) { el ->
            el.select(".songs-list-row__by-line a").map { it.text() }.joinToString { it }
        }
    }

    override fun getAlbumName(element: Element): String {
        return generateText(element) { el ->
            el.select(".songs-list__col.songs-list__col--tertiary span a").first()?.text() ?: "없음"
        }
    }

    override fun getRank(element: Element): String {
        return generateText(element) { el ->
            el.select(".songs-list-row__rank").first()?.text() ?: "없음"
        }
    }

    override fun getImageUrl(element: Element): String {
        return generateText(element) { el ->
            el.select(".songs-list-row__artwork-wrapper source").first()
                ?.attr("srcset")
                ?.split("40w")
                ?.get(0)
                ?: "없음"
        }
    }
}