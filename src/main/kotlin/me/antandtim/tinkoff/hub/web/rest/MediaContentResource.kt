package me.antandtim.tinkoff.hub.web.rest

import io.github.jhipster.web.util.ResponseUtil
import me.antandtim.tinkoff.hub.service.MediaContentService
import me.antandtim.tinkoff.hub.service.dto.MediaContentDTO
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
/**
 * REST controller for managing [me.antandtim.tinkoff.hub.domain.MediaContent].
 */
@RestController
@RequestMapping("/api")
class MediaContentResource(
    private val mediaContentService: MediaContentService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * `GET  /media-contents` : get all the mediaContents.
     *

     * @return the [ResponseEntity] with status `200 (OK)` and the list of mediaContents in body.
     */
    @GetMapping("/media-contents")
    fun getAllMediaContents(): MutableList<MediaContentDTO> {
        log.debug("REST request to get all MediaContents")
        return mediaContentService.findAll()
    }

    /**
     * `GET  /media-contents/:id` : get the "id" mediaContent.
     *
     * @param id the id of the mediaContentDTO to retrieve.
     * @return the [ResponseEntity] with status `200 (OK)` and with body the mediaContentDTO, or with status `404 (Not Found)`.
     */
    @GetMapping("/media-contents/{id}")
    fun getMediaContent(@PathVariable id: Long): ResponseEntity<MediaContentDTO> {
        log.debug("REST request to get MediaContent : {}", id)
        val mediaContentDTO = mediaContentService.findOne(id)
        return ResponseUtil.wrapOrNotFound(mediaContentDTO)
    }
}
