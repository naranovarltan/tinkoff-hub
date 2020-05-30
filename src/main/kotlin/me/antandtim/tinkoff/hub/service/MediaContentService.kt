package me.antandtim.tinkoff.hub.service
import me.antandtim.tinkoff.hub.domain.MediaContent
import me.antandtim.tinkoff.hub.repository.MediaContentRepository
import me.antandtim.tinkoff.hub.service.dto.MediaContentDTO
import me.antandtim.tinkoff.hub.service.mapper.MediaContentMapper
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.util.Optional

/**
 * Service Implementation for managing [MediaContent].
 */
@Service
@Transactional
class MediaContentService(
    private val mediaContentRepository: MediaContentRepository,
    private val mediaContentMapper: MediaContentMapper
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * Save a mediaContent.
     *
     * @param mediaContentDTO the entity to save.
     * @return the persisted entity.
     */
    fun save(mediaContentDTO: MediaContentDTO): MediaContentDTO {
        log.debug("Request to save MediaContent : {}", mediaContentDTO)

        var mediaContent = mediaContentMapper.toEntity(mediaContentDTO)
        mediaContent = mediaContentRepository.save(mediaContent)
        return mediaContentMapper.toDto(mediaContent)
    }

    /**
     * Get all the mediaContents.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    fun findAll(): MutableList<MediaContentDTO> {
        log.debug("Request to get all MediaContents")
        return mediaContentRepository.findAll()
            .mapTo(mutableListOf(), mediaContentMapper::toDto)
    }

    /**
     * Get one mediaContent by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    fun findOne(id: Long): Optional<MediaContentDTO> {
        log.debug("Request to get MediaContent : {}", id)
        return mediaContentRepository.findById(id)
            .map(mediaContentMapper::toDto)
    }

    /**
     * Delete the mediaContent by id.
     *
     * @param id the id of the entity.
     */
    fun delete(id: Long) {
        log.debug("Request to delete MediaContent : {}", id)

        mediaContentRepository.deleteById(id)
    }
}
