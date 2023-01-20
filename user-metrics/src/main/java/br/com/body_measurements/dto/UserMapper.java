package br.com.body_measurements.dto;

import br.com.body_measurements.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "cdi",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    UserEntity toEntity(UserDTO domain);

    UserDTO toDomain(UserEntity entity);
}
