package co.shoppu.oauth.controller

import co.shoppu.oauth.domain.User
import co.shoppu.oauth.services.UserGormService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/test")
class TestController {

    protected final UserGormService userGormService

    TestController(UserGormService userGormService) {
        this.userGormService = userGormService
    }

    @Get
    User getUser(){
        userGormService.save("demo","demo");
    }

    @Get("/getall")
    def getUserAll(){
       userGormService.findByUsername("demo")
    }

}
