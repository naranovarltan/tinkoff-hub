package me.antandtim.tinkoff.hub.repository

import me.antandtim.tinkoff.hub.domain.MediaContent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Spring Data  repository for the [MediaContent] entity.
 */
@Suppress("unused")
@Repository
interface MediaContentRepository : JpaRepository<MediaContent, Long>
