package com.project.colochub.Models.Entities.App;

import com.project.colochub.Models.Enums.HouseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    @Id
    private Integer id;
    @NotBlank(message = "HouseType is mendatory")
    private HouseType  houseType;
    @NotBlank
    private String address;
    @NotEmpty
    private Integer rooms;
    @NotEmpty
    private Integer kitchens;
    @NotEmpty
    private Integer bathrooms;
}
