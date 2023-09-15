package com.mango.music.domain.chart

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource

@ActiveProfiles("test")
@DataJpaTest
@TestPropertySource(locations = ["classpath:application-test.yml"])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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