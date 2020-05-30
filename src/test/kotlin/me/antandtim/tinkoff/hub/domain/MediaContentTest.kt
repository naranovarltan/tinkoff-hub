package me.antandtim.tinkoff.hub.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import me.antandtim.tinkoff.hub.web.rest.equalsVerifier

class MediaContentTest {

    @Test
    fun equalsVerifier() {
        equalsVerifier(MediaContent::class)
        val mediaContent1 = MediaContent()
        mediaContent1.id = 1L
        val mediaContent2 = MediaContent()
        mediaContent2.id = mediaContent1.id
        assertThat(mediaContent1).isEqualTo(mediaContent2)
        mediaContent2.id = 2L
        assertThat(mediaContent1).isNotEqualTo(mediaContent2)
        mediaContent1.id = null
        assertThat(mediaContent1).isNotEqualTo(mediaContent2)
    }
}
