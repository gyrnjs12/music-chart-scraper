package com.mango.music.domain.chart


import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@DataJpaTest
@ExtendWith(SpringExtension::class)
class SongRepositoryTest @Autowired constructor(
    private val songRepository: SongRepository,
) {

    @Test
    @DisplayName("DB 저장 테스트")
    fun saveTest() {

        // given
        val chart = SongFixture.fixture("hello")

        // when
        val saveChart = songRepository.save(chart)

        // then
        assertThat(chart.title).isEqualTo(saveChart.title)
    }
}