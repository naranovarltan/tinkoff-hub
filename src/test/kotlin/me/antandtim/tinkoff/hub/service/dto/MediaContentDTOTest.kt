package me.antandtim.tinkoff.hub.service.dto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import me.antandtim.tinkoff.hub.web.rest.equalsVerifier

class MediaContentDTOTest {

    @Test
    fun dtoEqualsVerifier(){
        equalsVerifier(MediaContentDTO::class)
        val mediaContentDTO1 = MediaContentDTO()
        mediaContentDTO1.id = 1L
        val mediaContentDTO2 = MediaContentDTO()
        assertThat(mediaContentDTO1).isNotEqualTo(mediaContentDTO2)
        mediaContentDTO2.id = mediaContentDTO1.id
        assertThat(mediaContentDTO1).isEqualTo(mediaContentDTO2)
        mediaContentDTO2.id = 2L
        assertThat(mediaContentDTO1).isNotEqualTo(mediaContentDTO2)
        mediaContentDTO1.id = null
        assertThat(mediaContentDTO1).isNotEqualTo(mediaContentDTO2)
    }
}
