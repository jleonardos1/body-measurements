package br.com.body_measurements.dto;

import br.com.body_measurements.entity.MeasurementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "cdi",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface MeasurementMapper {

    MeasurementEntity toEntity(MeasurementDTO domain);

    MeasurementDTO toDomain(MeasurementEntity entity);

    List<MeasurementDTO> fromList(List<MeasurementEntity> entity);
}
