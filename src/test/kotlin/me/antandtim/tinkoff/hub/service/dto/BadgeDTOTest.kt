package me.antandtim.tinkoff.hub.service.dto

import me.antandtim.tinkoff.hub.web.rest.equalsVerifier
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BadgeDTOTest {

    @Test
    fun dtoEqualsVerifier() {
        equalsVerifier(BadgeDTO::class)
        val badgeDTO1 = BadgeDTO()
        badgeDTO1.id = 1L
        val badgeDTO2 = BadgeDTO()
        assertThat(badgeDTO1).isNotEqualTo(badgeDTO2)
        badgeDTO2.id = badgeDTO1.id
        assertThat(badgeDTO1).isEqualTo(badgeDTO2)
        badgeDTO2.id = 2L
        assertThat(badgeDTO1).isNotEqualTo(badgeDTO2)
        badgeDTO1.id = null
        assertThat(badgeDTO1).isNotEqualTo(badgeDTO2)
    }
}
