package co.shoppu.oauth.config

import co.shoppu.oauth.domain.User
import co.shoppu.oauth.services.UserGormService
import io.micronaut.security.authentication.AuthenticationFailed
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.UserDetails
import io.reactivex.Flowable
import org.reactivestreams.Publisher

import javax.inject.Singleton

@Singleton
class AuthenticationProviderImpl implements AuthenticationProvider {

    protected final UserGormService userGormService

    AuthenticationProviderImpl(UserGormService userGormService) {
        this.userGormService = userGormService
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {

        String username = (String) authenticationRequest.getIdentity().toString()
        String password = (String) authenticationRequest.getSecret().toString()

        println(username)
        println(password)

        User user = userGormService.findByUsernameAndPassword(username,password)
        if (user != null ) {
            return Flowable.just(new UserDetails(username,[]))
        }
        return Flowable.just(new AuthenticationFailed())
    }
}