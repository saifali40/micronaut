package co.shoppu.oauth.services

import co.shoppu.oauth.domain.User
import grails.gorm.services.Service

@Service(User)
interface UserGormService {

    User save(String username, String password)

    User findByUsername(String username)

    User findByUsernameAndPassword(String username,String password)

    User findById(Serializable id)

    void delete(Serializable id)
}