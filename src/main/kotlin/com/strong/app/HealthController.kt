package com.strong.app

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.time.LocalDateTime

@Controller
class HealthController {
  @Get(value = "/ping", produces = [MediaType.TEXT_PLAIN])
  fun pong() = "ping at ${LocalDateTime.now()}"
}
