package br.com.body_measurements.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "app_user_metrics")
public class UserMetricsEntity {

    @Id
    @GeneratedValue
    public Long id;
    private Long userId;
    private String items;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}