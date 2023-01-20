package br.com.body_measurements.service;

import br.com.body_measurements.entity.UserMetricsEntity;
import br.com.body_measurements.repository.UserMetricsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.body_measurements.dto.MetricDTO;
import br.com.body_measurements.dto.UserMetricsDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
public class UserMetricsService {

    @Inject
    UserMetricsRepository repository;

    @Inject
    ObjectMapper objectMapper;

    @Transactional
    public UserMetricsDTO save(UserMetricsDTO dto) throws JsonProcessingException {

        String jsonValue = objectMapper.writeValueAsString(dto.getItems());

        UserMetricsEntity entity = UserMetricsEntity.builder()
                .userId(dto.getUserId())
                .items(jsonValue)
                .build();

        repository.persist(entity);
        dto.setId(entity.getId());

        return dto;
    }

    public List<UserMetricsDTO> findAll() throws JsonProcessingException {
        List<UserMetricsEntity> list = repository.findAll().list();
        List<UserMetricsDTO> dtoList = new ArrayList<>();

        for (UserMetricsEntity entity : list) {
            List<MetricDTO> items = Arrays.asList(objectMapper.readValue(entity.getItems(), MetricDTO[].class));
            List<MetricDTO> calculated = mapNewMetrics(items);

            UserMetricsDTO dto = UserMetricsDTO
                    .builder()
                    .userId(entity.getUserId())
                    .items(items)
                    .calculated(calculated)
                    .build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    List<MetricDTO> mapNewMetrics(List<MetricDTO> metrics) {
        Map<String, Double> map = new HashMap<>();
        metrics.forEach(item -> map.put(item.getName(), item.getValue()));

        return MetricsCalculator.list(map);
    }
}
