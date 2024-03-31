package com.project.colochub.Models.Entities;

import com.project.colochub.Security.Model.Entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    @NotEmpty
    private Double monthly_price;

    //RelationShips
    @ManyToOne
    private House house;
    @ManyToOne
    private User owner;
    @OneToMany(mappedBy = "offer")
    private List<Subscription> subscriptions_list;
}
