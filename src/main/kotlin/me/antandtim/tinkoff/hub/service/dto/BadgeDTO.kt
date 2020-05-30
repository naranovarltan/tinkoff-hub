package me.antandtim.tinkoff.hub.service.dto



import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import java.io.Serializable

/**
 * A DTO for the [me.antandtim.tinkoff.hub.domain.Badge] entity.
 */
data class BadgeDTO(
    
    var id: Long? = null,

    @get: NotNull
    var visible: Boolean? = null,

    @get: NotNull
    var description: String? = null,

    var imageId: Long? = null

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BadgeDTO) return false
        val badgeDTO = other as BadgeDTO
        if (badgeDTO.id == null || id == null) {
            return false
        }
        return id == badgeDTO.id
    }

    override fun hashCode() = id.hashCode()
}
