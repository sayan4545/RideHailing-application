package com.dev.sayan.ridehailing.ridehailingmonolith.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ORSMResponseDto {
    private List<ORSMRoute> routes;
}
