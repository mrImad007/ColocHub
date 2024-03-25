package com.project.colochub.Models.Entities.App;

import com.project.colochub.Models.Entities.Users.Owner;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    @NotEmpty
    private Double monthly_price;

    //RelationShips
    @OneToOne
    private House house;
    @ManyToOne
    private Owner owner;
    @OneToMany(mappedBy = "offer")
    private List<Subscription> subscriptions_list;
}
