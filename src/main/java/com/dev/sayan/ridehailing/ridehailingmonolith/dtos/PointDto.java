package com.dev.sayan.ridehailing.ridehailingmonolith.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointDto {
    private Double[] coordinates;

    private String type = "Point";

    public PointDto(Double[] coordinates) {
        this.coordinates = coordinates;
    }
}
