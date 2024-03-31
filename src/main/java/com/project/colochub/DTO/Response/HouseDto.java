package com.project.colochub.DTO.Response;

import com.project.colochub.Models.Enums.HouseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseDto {
    private Integer id;
    private HouseType houseType;
    @NotBlank(message = "Address is mendatory")
    private String address;
    private Integer rooms;
    private Integer kitchens;
    private Integer bathrooms;
    private UserDto owner;
}
