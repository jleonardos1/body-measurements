package br.com.body_measurements.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserMeasurementDTO {

    private Long id;

    @NotNull
    private Long measurementId;
    private String name;

    @Min(1)
    @Max(1000)
    private double value;

    @PastOrPresent
    private Date recordedAt;

    private Long userId;

    @Builder.Default
    private boolean active = true;


}
