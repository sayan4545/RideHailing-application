package com.dev.sayan.ridehailing.ridehailingmonolith.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.annotation.JsonSerialize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ORSMRoute {
    private Double distance;
    private Double duration;
}
