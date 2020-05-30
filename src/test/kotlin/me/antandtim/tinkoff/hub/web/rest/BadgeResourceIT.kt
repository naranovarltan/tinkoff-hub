package me.antandtim.tinkoff.hub.web.rest

import me.antandtim.tinkoff.hub.TinkoffHubApp
import me.antandtim.tinkoff.hub.domain.Badge
import me.antandtim.tinkoff.hub.domain.MediaContent
import me.antandtim.tinkoff.hub.repository.BadgeRepository
import me.antandtim.tinkoff.hub.service.BadgeService
import me.antandtim.tinkoff.hub.service.dto.BadgeDTO
import me.antandtim.tinkoff.hub.service.mapper.BadgeMapper
import me.antandtim.tinkoff.hub.web.rest.errors.ExceptionTranslator

import kotlin.test.assertNotNull

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.web.PageableHandlerMethodArgumentResolver
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.Validator
import javax.persistence.EntityManager

import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.hasItem
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


/**
 * Integration tests for the [BadgeResource] REST controller.
 *
 * @see BadgeResource
 */
@SpringBootTest(classes = [TinkoffHubApp::class])
class BadgeResourceIT {

    @Autowired
    private lateinit var badgeRepository: BadgeRepository

    @Autowired
    private lateinit var badgeMapper: BadgeMapper

    @Autowired
    private lateinit var badgeService: BadgeService

    @Autowired
    private lateinit var jacksonMessageConverter: MappingJackson2HttpMessageConverter

    @Autowired
    private lateinit var pageableArgumentResolver: PageableHandlerMethodArgumentResolver

    @Autowired
    private lateinit var exceptionTranslator: ExceptionTranslator

    @Autowired
    private lateinit var em: EntityManager

    @Autowired
    private lateinit var validator: Validator

    private lateinit var restBadgeMockMvc: MockMvc

    private lateinit var badge: Badge

    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val badgeResource = BadgeResource(badgeService)
        this.restBadgeMockMvc = MockMvcBuilders.standaloneSetup(badgeResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build()
    }

    @BeforeEach
    fun initTest() {
        badge = createEntity(em)
    }
    @Test
    @Transactional
    fun getAllBadges() {
        // Initialize the database
        badgeRepository.saveAndFlush(badge)

        // Get all the badgeList
        restBadgeMockMvc.perform(get("/api/badges?sort=id,desc"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(badge.id?.toInt())))
            .andExpect(jsonPath("$.[*].visible").value(hasItem(DEFAULT_VISIBLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
    }
    
    @Test
    @Transactional
    fun getBadge() {
        // Initialize the database
        badgeRepository.saveAndFlush(badge)

        val id = badge.id
        assertNotNull(id)

        // Get the badge
        restBadgeMockMvc.perform(get("/api/badges/{id}", id))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(id.toInt()))
            .andExpect(jsonPath("$.visible").value(DEFAULT_VISIBLE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
    }

    @Test
    @Transactional
    fun getNonExistingBadge() {
        // Get the badge
        restBadgeMockMvc.perform(get("/api/badges/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound)
    }

    companion object {

        private const val DEFAULT_VISIBLE: Boolean = false
        private const val UPDATED_VISIBLE: Boolean = true

        private const val DEFAULT_DESCRIPTION = "AAAAAAAAAA"
        private const val UPDATED_DESCRIPTION = "BBBBBBBBBB"

        /**
         * Create an entity for this test.
         *
         * This is a static method, as tests for other entities might also need it,
         * if they test an entity which requires the current entity.
         */
        @JvmStatic
        fun createEntity(em: EntityManager): Badge {
            val badge = Badge(
                visible = DEFAULT_VISIBLE,
                description = DEFAULT_DESCRIPTION
            )

            // Add required entity
            val mediaContent: MediaContent
            if (em.findAll(MediaContent::class).isEmpty()) {
                mediaContent = MediaContentResourceIT.createEntity(em)
                em.persist(mediaContent)
                em.flush()
            } else {
                mediaContent = em.findAll(MediaContent::class).get(0)
            }
            badge.image = mediaContent
            return badge
        }

        /**
         * Create an updated entity for this test.
         *
         * This is a static method, as tests for other entities might also need it,
         * if they test an entity which requires the current entity.
         */
        @JvmStatic
        fun createUpdatedEntity(em: EntityManager): Badge {
            val badge = Badge(
                visible = UPDATED_VISIBLE,
                description = UPDATED_DESCRIPTION
            )

            // Add required entity
            val mediaContent: MediaContent
            if (em.findAll(MediaContent::class).isEmpty()) {
                mediaContent = MediaContentResourceIT.createUpdatedEntity(em)
                em.persist(mediaContent)
                em.flush()
            } else {
                mediaContent = em.findAll(MediaContent::class).get(0)
            }
            badge.image = mediaContent
            return badge
        }
    }
}
