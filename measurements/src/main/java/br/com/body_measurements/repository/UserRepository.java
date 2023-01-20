package br.com.body_measurements.repository;

import br.com.body_measurements.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

    public UserEntity findByEmail(String email){
        return find("email", email).firstResult();
    }
}
