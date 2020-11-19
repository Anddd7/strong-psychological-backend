package com.strong.app.authentication

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.security.Principal
import javax.inject.Inject

@MicronautTest
internal class AuthenticationProviderUserPasswordTest {
  @Inject
  lateinit var server: EmbeddedServer

  @Inject
  @field:Client("/")
  lateinit var client: HttpClient

  @Test
  fun `should got 401 while anonymous access secured endpoint`() {
    val rsp = client.toBlocking().retrieve("/test/secured")
    assertEquals("Hello World", rsp)
  }
}

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/test/secured")
internal class SecuredController {
  @Get(produces = [MediaType.TEXT_PLAIN])
  fun profile(principal: Principal): String = principal.name
}
