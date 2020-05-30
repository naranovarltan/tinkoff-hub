package me.antandtim.tinkoff.hub.service.mapper

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

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
