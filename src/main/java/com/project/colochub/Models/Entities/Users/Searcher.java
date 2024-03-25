package com.project.colochub.Models.Entities.Users;

import com.project.colochub.Models.Entities.App.Subscription;
import com.project.colochub.Security.Model.Entity.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
public class Searcher extends User {
    @Nullable
    private String picture;

    //RelationShips
    @OneToMany(mappedBy = "searcher")
    private List<Subscription> subscriptions_list;
}
