package me.antandtim.tinkoff.hub.web.rest

import me.antandtim.tinkoff.hub.service.BadgeService
import me.antandtim.tinkoff.hub.web.rest.errors.BadRequestAlertException
import me.antandtim.tinkoff.hub.service.dto.BadgeDTO

import io.github.jhipster.web.util.HeaderUtil
import io.github.jhipster.web.util.ResponseUtil
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid
import java.net.URI
import java.net.URISyntaxException
import java.util.Objects
/**
 * REST controller for managing [me.antandtim.tinkoff.hub.domain.Badge].
 */
@RestController
@RequestMapping("/api")
class BadgeResource(
    private val badgeService: BadgeService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * `GET  /badges` : get all the badges.
     *

     * @return the [ResponseEntity] with status `200 (OK)` and the list of badges in body.
     */
    @GetMapping("/badges")    
    fun getAllBadges(): MutableList<BadgeDTO> {
        log.debug("REST request to get all Badges")
        return badgeService.findAll()
    }

    /**
     * `GET  /badges/:id` : get the "id" badge.
     *
     * @param id the id of the badgeDTO to retrieve.
     * @return the [ResponseEntity] with status `200 (OK)` and with body the badgeDTO, or with status `404 (Not Found)`.
     */
    @GetMapping("/badges/{id}")
    fun getBadge(@PathVariable id: Long): ResponseEntity<BadgeDTO> {
        log.debug("REST request to get Badge : {}", id)
        val badgeDTO = badgeService.findOne(id)
        return ResponseUtil.wrapOrNotFound(badgeDTO)
    }
}
