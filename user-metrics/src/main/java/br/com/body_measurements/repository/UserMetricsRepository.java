package br.com.body_measurements.repository;

import br.com.body_measurements.entity.UserMetricsEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMetricsRepository implements PanacheRepository<UserMetricsEntity> {
}
