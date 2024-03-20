package com.project.colochub.Models.Entities.Users;

import com.project.colochub.Security.Model.Entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@EqualsAndHashCode(callSuper = true)
public class Admin extends User {

}
