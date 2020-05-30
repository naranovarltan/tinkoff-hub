package me.antandtim.tinkoff.hub.service.mapper

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BadgeMapperTest {

    private lateinit var badgeMapper: BadgeMapper

    @BeforeEach
    fun setUp() {
        badgeMapper = BadgeMapperImpl()
    }

    @Test
    fun testEntityFromId() {
        val id = 1L
        assertThat(badgeMapper.fromId(id)?.id).isEqualTo(id)
        assertThat(badgeMapper.fromId(null)).isNull()
    }
}
