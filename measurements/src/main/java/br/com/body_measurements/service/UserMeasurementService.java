package br.com.body_measurements.service;

import br.com.body_measurements.dto.UserMeasurementDTO;
import br.com.body_measurements.dto.UserMeasurementMapper;
import br.com.body_measurements.entity.UserMeasurementEntity;
import br.com.body_measurements.repository.UserMeasurementRepository;
import br.com.body_measurements.DateUtils;
import br.com.body_measurements.QueryLoaderUtil;
import br.com.body_measurements.client.MetricsClient;
import br.com.body_measurements.dto.MetricDTO;
import br.com.body_measurements.dto.UserMetricsDTO;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@AllArgsConstructor
public class UserMeasurementService {

    private static final String PATH = "./measurements/src/main/resources/sql/";
    private static final String FIND_BY_USER = "UserMeasurementService.findByUser";

    @Inject
    UserMeasurementRepository repository;

    @Inject
    QueryLoaderUtil queryLoader;

    @Inject
    UserMeasurementMapper mapper;

    @RestClient
    MetricsClient metricsClient;

    @Transactional
    public UserMeasurementDTO save(UserMeasurementDTO userMeasurementDTO) {
        UserMeasurementEntity entity = mapper.toEntity(userMeasurementDTO);
        repository.persist(entity);

        List<MetricDTO> items = new ArrayList<>();

        MetricDTO metricDTO = MetricDTO.builder()
                .name(userMeasurementDTO.getName())
                .value(userMeasurementDTO.getValue())
                .recordedAt(userMeasurementDTO.getRecordedAt())
                .build();

        items.add(metricDTO);

        UserMetricsDTO userMetricsDTO = UserMetricsDTO.builder()
                .userId(userMeasurementDTO.getUserId())
                .items(items)
                .build();

        metricsClient.save(userMetricsDTO);

        return mapper.toDomain(entity);
    }

    public List findByUserId(Long userId) {

        Map<String, Object> params = new HashMap<>();
        params.put("user_id", userId);

        return repository
                .search(queryLoader.getQuery(PATH, FIND_BY_USER), params, UserMeasurementDTO.class);
    }

    @Transactional
    public void delete(Long userMeasurementId) {
        repository.deleteById(userMeasurementId);
    }

    @Transactional
    public UserMeasurementDTO update(UserMeasurementDTO dto) {
        UserMeasurementEntity entity = repository.findById(dto.getId());

        entity.setRecordedAt(DateUtils.convert(dto.getRecordedAt()));
        entity.setMeasurementId(dto.getMeasurementId());
        entity.setActive(dto.isActive());
        entity.setValue(dto.getValue());

        repository.persist(entity);

        return mapper.toDomain(entity);
    }

}
