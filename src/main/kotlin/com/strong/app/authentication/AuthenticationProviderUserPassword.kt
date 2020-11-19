package com.strong.app.authentication

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationFailed
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.UserDetails
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import javax.inject.Singleton

@Singleton
class AuthenticationProviderUserPassword : AuthenticationProvider {
  override fun authenticate(
    httpRequest: HttpRequest<*>?,
    authenticationRequest: AuthenticationRequest<*, *>
  ): Publisher<AuthenticationResponse> {
    val identity = authenticationRequest.identity
    val secret = authenticationRequest.secret

    if (identity == "sherlock" && secret == "password") {
      return Flowable.just(UserDetails(identity as String, listOf()))
    }
    return Flowable.just(AuthenticationFailed())
  }
}
