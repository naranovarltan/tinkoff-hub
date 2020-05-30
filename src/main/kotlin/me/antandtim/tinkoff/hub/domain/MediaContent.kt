package me.antandtim.tinkoff.hub.domain



import javax.persistence.*
import javax.validation.constraints.*

import java.io.Serializable

/**
 * A MediaContent.
 */
@Entity
@Table(name = "media_content")
data class MediaContent(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    var id: Long? = null,
    
    @Lob
    @Column(name = "media", nullable = false)
    var media: ByteArray? = null,

    @Column(name = "media_content_type", nullable = false)
    var mediaContentType: String? = null

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
) : Serializable {
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MediaContent) return false

        return id != null && other.id != null && id == other.id
    }

    override fun hashCode() = 31

    override fun toString() = "MediaContent{" +
        "id=$id" +
        ", media='$media'" +
        ", mediaContentType='$mediaContentType'" +
        "}"


    companion object {
        private const val serialVersionUID = 1L
    }
}
