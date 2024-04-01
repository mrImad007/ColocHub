package com.project.colochub.DTO.Request;

import com.project.colochub.Models.Entities.House;
import com.project.colochub.Models.Entities.Photo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoReq {
    private String image;
    private Integer house_id;

    public Photo toModel() {
        House house = House.builder().id(this.house_id).build();
        return Photo.builder()
                .image(this.image)
                .house(house)
                .build();
    }
}
