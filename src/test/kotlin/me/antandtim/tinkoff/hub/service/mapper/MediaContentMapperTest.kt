package me.antandtim.tinkoff.hub.service.mapper

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MediaContentMapperTest {

    private lateinit var mediaContentMapper: MediaContentMapper

    @BeforeEach
    fun setUp() {
        mediaContentMapper = MediaContentMapperImpl()
    }

    @Test
    fun testEntityFromId() {
        val id = 1L
        assertThat(mediaContentMapper.fromId(id)?.id).isEqualTo(id)
        assertThat(mediaContentMapper.fromId(null)).isNull()
    }
}
