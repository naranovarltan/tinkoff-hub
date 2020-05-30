package me.antandtim.tinkoff.hub.web.rest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * TestResource controller
 */
@RestController
@RequestMapping("/api/test")
class TestResource {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
    * GET testMethod
    */
    @GetMapping("/test-method")
    fun testMethod(): String =
        "testMethod"
}
