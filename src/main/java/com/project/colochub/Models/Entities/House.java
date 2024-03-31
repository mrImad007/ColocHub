package com.project.colochub.Models.Entities;

import com.project.colochub.Models.Enums.HouseType;
import com.project.colochub.Security.Model.Entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private HouseType  houseType;
    @NotBlank
    private String address;
    private Integer rooms;
    private Integer kitchens;
    private Integer bathrooms;

    //RelationShips
    @ManyToOne
    private User owner;
    @OneToMany(mappedBy = "house")
    private List<Photo> photos_list;
    @OneToMany(mappedBy = "house")
    private List<Offer> offers_list;
}
