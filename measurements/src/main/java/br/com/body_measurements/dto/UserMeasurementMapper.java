package br.com.body_measurements.dto;

import br.com.body_measurements.entity.UserMeasurementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "cdi",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserMeasurementMapper {

    UserMeasurementEntity toEntity(UserMeasurementDTO domain);

    UserMeasurementDTO toDomain(UserMeasurementEntity entity);
}
