package com.example.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

@MicronautTest
class HelloControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun helloWorldTest() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body: String = client.toBlocking().retrieve(request)

        assertNotNull(body)
        assertEquals("Hello World!", body)
    }

}
