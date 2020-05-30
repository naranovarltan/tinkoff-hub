package me.antandtim.tinkoff.hub.repository

import me.antandtim.tinkoff.hub.domain.Badge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Spring Data  repository for the [Badge] entity.
 */
@Suppress("unused")
@Repository
interface BadgeRepository : JpaRepository<Badge, Long>
