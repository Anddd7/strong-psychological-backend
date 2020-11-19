package com.strong.app.api

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class HealthControllerTest {

  @Inject
  lateinit var server: EmbeddedServer

  @Inject
  @field:Client("/")
  lateinit var client: HttpClient

  @Test
  fun `should get pong`() {
    val rsp = client.toBlocking().retrieve("/ping")
    assertEquals("pong", rsp)
  }
}
