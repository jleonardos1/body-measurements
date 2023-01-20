package br.com.body_measurements.service;

import br.com.body_measurements.dto.MeasurementMapper;
import br.com.body_measurements.dto.MeasurementDTO;
import br.com.body_measurements.repository.MeasurementRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MeasurementService {

    @Inject
    MeasurementRepository repository;

    @Inject
    MeasurementMapper mapper;

    public List<MeasurementDTO> findAll() {
        return mapper.fromList(repository.listAll());
    }
}
