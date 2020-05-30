package me.antandtim.tinkoff.hub.web.rest

import me.antandtim.tinkoff.hub.TinkoffHubApp
import me.antandtim.tinkoff.hub.domain.MediaContent
import me.antandtim.tinkoff.hub.repository.MediaContentRepository
import me.antandtim.tinkoff.hub.service.MediaContentService
import me.antandtim.tinkoff.hub.service.dto.MediaContentDTO
import me.antandtim.tinkoff.hub.service.mapper.MediaContentMapper
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
import org.springframework.util.Base64Utils
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
 * Integration tests for the [MediaContentResource] REST controller.
 *
 * @see MediaContentResource
 */
@SpringBootTest(classes = [TinkoffHubApp::class])
class MediaContentResourceIT {

    @Autowired
    private lateinit var mediaContentRepository: MediaContentRepository

    @Autowired
    private lateinit var mediaContentMapper: MediaContentMapper

    @Autowired
    private lateinit var mediaContentService: MediaContentService

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

    private lateinit var restMediaContentMockMvc: MockMvc

    private lateinit var mediaContent: MediaContent

    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val mediaContentResource = MediaContentResource(mediaContentService)
        this.restMediaContentMockMvc = MockMvcBuilders.standaloneSetup(mediaContentResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build()
    }

    @BeforeEach
    fun initTest() {
        mediaContent = createEntity(em)
    }
    @Test
    @Transactional
    fun getAllMediaContents() {
        // Initialize the database
        mediaContentRepository.saveAndFlush(mediaContent)

        // Get all the mediaContentList
        restMediaContentMockMvc.perform(get("/api/media-contents?sort=id,desc"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mediaContent.id?.toInt())))
            .andExpect(jsonPath("$.[*].mediaContentType").value(hasItem(DEFAULT_MEDIA_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].media").value(hasItem(Base64Utils.encodeToString(DEFAULT_MEDIA))))
    }
    
    @Test
    @Transactional
    fun getMediaContent() {
        // Initialize the database
        mediaContentRepository.saveAndFlush(mediaContent)

        val id = mediaContent.id
        assertNotNull(id)

        // Get the mediaContent
        restMediaContentMockMvc.perform(get("/api/media-contents/{id}", id))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(id.toInt()))
            .andExpect(jsonPath("$.mediaContentType").value(DEFAULT_MEDIA_CONTENT_TYPE))
            .andExpect(jsonPath("$.media").value(Base64Utils.encodeToString(DEFAULT_MEDIA)))
    }

    @Test
    @Transactional
    fun getNonExistingMediaContent() {
        // Get the mediaContent
        restMediaContentMockMvc.perform(get("/api/media-contents/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound)
    }

    companion object {

        private val DEFAULT_MEDIA: ByteArray = createByteArray(1, "0")
        private val UPDATED_MEDIA: ByteArray = createByteArray(1, "1")
        private const val DEFAULT_MEDIA_CONTENT_TYPE: String = "image/jpg"
        private const val UPDATED_MEDIA_CONTENT_TYPE: String = "image/png"

        /**
         * Create an entity for this test.
         *
         * This is a static method, as tests for other entities might also need it,
         * if they test an entity which requires the current entity.
         */
        @JvmStatic
        fun createEntity(em: EntityManager): MediaContent {
            val mediaContent = MediaContent(
                media = DEFAULT_MEDIA,
                mediaContentType = DEFAULT_MEDIA_CONTENT_TYPE
            )

            return mediaContent
        }

        /**
         * Create an updated entity for this test.
         *
         * This is a static method, as tests for other entities might also need it,
         * if they test an entity which requires the current entity.
         */
        @JvmStatic
        fun createUpdatedEntity(em: EntityManager): MediaContent {
            val mediaContent = MediaContent(
                media = UPDATED_MEDIA,
                mediaContentType = UPDATED_MEDIA_CONTENT_TYPE
            )

            return mediaContent
        }
    }
}
