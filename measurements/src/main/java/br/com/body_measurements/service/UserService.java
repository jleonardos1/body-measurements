package br.com.body_measurements.service;

import br.com.body_measurements.dto.UserMapper;
import br.com.body_measurements.dto.UserDTO;
import br.com.body_measurements.repository.UserRepository;
import br.com.body_measurements.entity.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    UserMapper mapper;

    @Inject
    UserRepository repository;

    @Transactional
    public UserDTO save(UserDTO userDTO) {
        UserEntity entity = mapper.toEntity(userDTO);
        repository.persist(mapper.toEntity(userDTO));
        return mapper.toDomain(entity);
    }

    public UserDTO findByEmail(String email) {
        return mapper.toDomain(repository.find("email", email).singleResult());
    }
}
