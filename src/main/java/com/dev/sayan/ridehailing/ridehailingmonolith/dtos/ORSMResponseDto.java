package com.dev.sayan.ridehailing.ridehailingmonolith.dtos;

//import com.dev.sayan.ridehailing.ridehailingmonolith.services.impl.ORSMRoute;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ORSMResponseDto {
    private String code;
    private String message;
    private List<RouteDto> routes;
}
