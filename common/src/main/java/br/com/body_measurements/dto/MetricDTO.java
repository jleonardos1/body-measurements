package br.com.body_measurements.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MetricDTO {

    private String name;
    @Min(1)
    @Max(1000)
    private double value;
    @PastOrPresent
    private Date recordedAt;
}
