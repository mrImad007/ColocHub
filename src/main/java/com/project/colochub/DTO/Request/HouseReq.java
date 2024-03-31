package com.project.colochub.DTO.Request;

import com.project.colochub.Models.Entities.House;
import com.project.colochub.Models.Enums.HouseType;
import com.project.colochub.Security.Model.Entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseReq {
    private HouseType houseType;
    private String address;
    private Integer rooms;
    private Integer kitchens;
    private Integer bathrooms;
    private Integer owner_id;

    public House toModel(){
        User owner = User.builder().id(this.owner_id).build();

        return House
                .builder()
                .houseType(this.houseType)
                .address(this.address)
                .rooms(this.rooms)
                .kitchens(this.kitchens)
                .bathrooms(this.bathrooms)
                .owner(owner)
                .build();
    }
}
