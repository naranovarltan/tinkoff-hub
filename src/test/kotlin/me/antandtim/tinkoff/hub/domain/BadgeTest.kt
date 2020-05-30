package me.antandtim.tinkoff.hub.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import me.antandtim.tinkoff.hub.web.rest.equalsVerifier

class BadgeTest {

    @Test
    fun equalsVerifier() {
        equalsVerifier(Badge::class)
        val badge1 = Badge()
        badge1.id = 1L
        val badge2 = Badge()
        badge2.id = badge1.id
        assertThat(badge1).isEqualTo(badge2)
        badge2.id = 2L
        assertThat(badge1).isNotEqualTo(badge2)
        badge1.id = null
        assertThat(badge1).isNotEqualTo(badge2)
    }
}
