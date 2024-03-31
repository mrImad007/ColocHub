package com.project.colochub.DTO.Response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferDto {
    private Integer id;
    @NotBlank(message = "Description is mendatory")
    private String description;
    @NotEmpty(message = "Monthly price is mendatory")
    private Double monthly_price;
}
