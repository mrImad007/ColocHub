package com.project.colochub.Models.Entities.Users;

import com.project.colochub.Security.Model.Entity.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@EqualsAndHashCode(callSuper = true)
public class Searcher extends User {
    @Nullable
    private String picture;
}
