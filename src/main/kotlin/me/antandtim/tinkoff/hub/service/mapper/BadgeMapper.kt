package me.antandtim.tinkoff.hub.service.mapper

import me.antandtim.tinkoff.hub.domain.Badge
import me.antandtim.tinkoff.hub.service.dto.BadgeDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

/**
 * Mapper for the entity [Badge] and its DTO [BadgeDTO].
 */
@Mapper(componentModel = "spring", uses = [MediaContentMapper::class])
interface BadgeMapper :
    EntityMapper<BadgeDTO, Badge> {

    @Mappings(
        Mapping(source = "image.id", target = "imageId")
    )
    override fun toDto(badge: Badge): BadgeDTO

    @Mappings(
        Mapping(source = "imageId", target = "image")
    )
    override fun toEntity(badgeDTO: BadgeDTO): Badge

    @JvmDefault
    fun fromId(id: Long?) = id?.let {
        val badge = Badge()
        badge.id = id
        badge
    }
}
