package com.strong.app.api

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller
@Secured(SecurityRule.IS_ANONYMOUS)
class HealthController {
  @Get(value = "/ping", produces = [MediaType.TEXT_PLAIN])
  fun pong() = "pong"
}
