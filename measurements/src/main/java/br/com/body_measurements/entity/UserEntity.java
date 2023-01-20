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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class UserEntity {

    @Id
    @GeneratedValue
    public Long id;
    private String externalId;
    private String name;
    private String username;
    private String email;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}