package me.antandtim.tinkoff.hub.domain

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.*

/**
 * A Badge.
 */
@Entity
@Table(name = "badge")
data class Badge(
    @Id
    var id: Long? = null,
    @get: NotNull
    @Column(name = "visible", nullable = false)
    var visible: Boolean? = null,

    @get: NotNull
    @Column(name = "description", nullable = false)
    var description: String? = null,

    @MapsId
    @NotNull
    @JoinColumn(name = "id")
    @OneToOne(optional = false)
    var image: MediaContent? = null

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
) : Serializable {
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Badge) return false

        return id != null && other.id != null && id == other.id
    }

    override fun hashCode() = 31

    override fun toString() = "Badge{" +
        "id=$id" +
        ", visible='$visible'" +
        ", description='$description'" +
        "}"

    companion object {
        private const val serialVersionUID = 1L
    }
}
