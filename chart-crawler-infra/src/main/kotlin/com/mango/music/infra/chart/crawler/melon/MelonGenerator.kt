package com.mango.music.infra.chart.crawler.melon

import com.mango.music.domain.chart.ChartKind
import com.mango.music.infra.chart.common.BaseChartCrawler
import org.jsoup.nodes.Element

class MelonGenerator : BaseChartCrawler(ChartKind.MELON) {

    val chartElements = select("tr.lst50,tr.lst100")

    override fun getSongName(element: Element): String {
        return generateText(element) { el ->
            el.select("div.wrap_song_info div.ellipsis.rank01 a").first()?.text() ?: "없음"
        }
    }

    override fun getArtistName(element: Element): String {
        return generateText(element) { el ->
            el.select("div.wrap_song_info div.ellipsis.rank02 a").first()?.text() ?: "없음"
        }
    }

    override fun getAlbumName(element: Element): String {
        return generateText(element) { el ->
            el.select("div.wrap_song_info div.ellipsis.rank03 a").first()?.text() ?: "없음"
        }
    }

    override fun getRank(element: Element): String {
        return generateText(element) { el ->
            el.select("div.t_center span.rank").first()?.text() ?: "없음"
        }
    }

    override fun getImageUrl(element: Element): String {
        return generateText(element) { el ->
            el.selectFirst("img[src^='https://cdnimg.melon.co.kr/']")?.attr("src") ?: "없음"
        }
    }

}