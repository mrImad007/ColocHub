package com.project.colochub.DTO.Request;

import com.project.colochub.Models.Entities.House;
import com.project.colochub.Models.Entities.Offer;
import com.project.colochub.Security.Model.Entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferReq {
    private String description;
    private Double monthly_price;
    private Integer house_id;
    private Integer owner_id;

    public Offer toModel(){
        House house = House.builder().id(this.house_id).build();
        User owner = User.builder().id(this.owner_id).build();
        return Offer
                .builder()
                .description(this.description)
                .monthly_price(this.monthly_price)
                .owner(owner)
                .house(house)
                .build();
    }
}
