package br.com.body_measurements.repository;

import br.com.body_measurements.entity.MeasurementEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MeasurementRepository implements PanacheRepository<MeasurementEntity> {
    
}
