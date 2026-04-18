package com.dev.sayan.ridehailing.ridehailingmonolith.advices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

public class ApiResponse<T> {
    private T data;
    private ApiError error;
    private LocalDateTime timestamp;

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error){
        this();
        this.error = error;
    }

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }
}
