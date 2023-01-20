package br.com.body_measurements.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user_measurement")
public class UserMeasurementEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long measurementId;
    private double value;
    private Timestamp recordedAt;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
