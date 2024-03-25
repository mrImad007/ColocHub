package com.project.colochub.Models.Entities.Users;

import com.project.colochub.Models.Entities.App.House;
import com.project.colochub.Models.Entities.App.Offer;
import com.project.colochub.Security.Model.Entity.User;
import jakarta.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
public class Owner extends User {
    @Nullable
    private String picture;

    //RelationShips
    @OneToMany(mappedBy = "owner")
    private List<House> houses_list;
    @OneToMany(mappedBy = "owner")
    private List<Offer> offers_list;
}
