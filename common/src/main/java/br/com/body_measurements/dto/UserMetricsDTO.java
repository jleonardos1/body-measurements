package br.com.body_measurements.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.annotations.Type;

import java.util.List;

@Data
@Jacksonized
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMetricsDTO {

    public Long id;
    private Long userId;
    @Type(type = "json")
    private List<MetricDTO> items;
    @Builder.Default
    private boolean active = true;
    private List<MetricDTO> calculated;
}
