package me.antandtim.tinkoff.hub.web.rest

import me.antandtim.tinkoff.hub.TinkoffHubApp
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
/**
 * Test class for the TestResource REST controller.
 *
 * @see TestResource
 */
@SpringBootTest(classes = [TinkoffHubApp::class])
class TestResourceIT {

    private lateinit var restMockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        val testResource = TestResource()
        restMockMvc = MockMvcBuilders
            .standaloneSetup(testResource)
            .build()
    }

    /**
    * Test testMethod
    */
    @Test
    @Throws(Exception::class)
    fun testTestMethod() {
        restMockMvc.perform(get("/api/test/test-method"))
            .andExpect(status().isOk)
    }

}
