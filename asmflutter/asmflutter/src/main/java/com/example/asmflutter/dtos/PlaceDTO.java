package com.example.asmflutter.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceDTO {
    private Long id;
    private String name;
    private String image;
    private Double star;
}
