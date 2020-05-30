package me.antandtim.tinkoff.hub.service.dto

import java.io.Serializable
import javax.persistence.Lob

/**
 * A DTO for the [me.antandtim.tinkoff.hub.domain.MediaContent] entity.
 */
data class MediaContentDTO(

    var id: Long? = null,

    @Lob
    var media: ByteArray? = null,
    var mediaContentType: String? = null

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MediaContentDTO) return false
        val mediaContentDTO = other as MediaContentDTO
        if (mediaContentDTO.id == null || id == null) {
            return false
        }
        return id == mediaContentDTO.id
    }

    override fun hashCode() = id.hashCode()
}
