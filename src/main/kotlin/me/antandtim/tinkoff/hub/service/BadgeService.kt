package me.antandtim.tinkoff.hub.service
import java.util.Optional
import me.antandtim.tinkoff.hub.domain.Badge
import me.antandtim.tinkoff.hub.repository.BadgeRepository
import me.antandtim.tinkoff.hub.repository.MediaContentRepository
import me.antandtim.tinkoff.hub.service.dto.BadgeDTO
import me.antandtim.tinkoff.hub.service.mapper.BadgeMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Service Implementation for managing [Badge].
 */
@Service
@Transactional
class BadgeService(
    private val badgeRepository: BadgeRepository,
    private val badgeMapper: BadgeMapper,
    private val mediaContentRepository: MediaContentRepository
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * Save a badge.
     *
     * @param badgeDTO the entity to save.
     * @return the persisted entity.
     */
    fun save(badgeDTO: BadgeDTO): BadgeDTO {
        log.debug("Request to save Badge : {}", badgeDTO)

        var badge = badgeMapper.toEntity(badgeDTO)
        val mediaContentId = badgeDTO.imageId
        if (mediaContentId != null) {
            mediaContentRepository.findById(mediaContentId)
                .ifPresent { badge.image = it }
        }
        badge = badgeRepository.save(badge)
        return badgeMapper.toDto(badge)
    }

    /**
     * Get all the badges.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    fun findAll(): MutableList<BadgeDTO> {
        log.debug("Request to get all Badges")
        return badgeRepository.findAll()
            .mapTo(mutableListOf(), badgeMapper::toDto)
    }

    /**
     * Get one badge by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    fun findOne(id: Long): Optional<BadgeDTO> {
        log.debug("Request to get Badge : {}", id)
        return badgeRepository.findById(id)
            .map(badgeMapper::toDto)
    }

    /**
     * Delete the badge by id.
     *
     * @param id the id of the entity.
     */
    fun delete(id: Long) {
        log.debug("Request to delete Badge : {}", id)

        badgeRepository.deleteById(id)
    }
}
