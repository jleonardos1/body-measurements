package br.com.body_measurements.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDTO {
    
    private Long id;
    private String name;
}
