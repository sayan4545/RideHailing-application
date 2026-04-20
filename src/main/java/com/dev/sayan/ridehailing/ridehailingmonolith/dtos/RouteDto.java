package com.dev.sayan.ridehailing.ridehailingmonolith.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteDto {
    private Double distance;
    private Double duration;
}
