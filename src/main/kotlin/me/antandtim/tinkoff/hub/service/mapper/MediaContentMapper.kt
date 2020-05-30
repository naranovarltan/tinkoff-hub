package me.antandtim.tinkoff.hub.service.mapper

import me.antandtim.tinkoff.hub.domain.MediaContent
import me.antandtim.tinkoff.hub.service.dto.MediaContentDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [MediaContent] and its DTO [MediaContentDTO].
 */
@Mapper(componentModel = "spring", uses = [])
interface MediaContentMapper :
    EntityMapper<MediaContentDTO, MediaContent> {

    override fun toEntity(mediaContentDTO: MediaContentDTO): MediaContent

    @JvmDefault
    fun fromId(id: Long?) = id?.let {
        val mediaContent = MediaContent()
        mediaContent.id = id
        mediaContent
    }
}
