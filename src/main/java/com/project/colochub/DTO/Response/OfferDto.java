package com.project.colochub.DTO.Response;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferDto {
    private Integer id;
    private String description;
    private Double monthly_price;
    private UserDto owner;
    private HouseDto houseDto;
}
