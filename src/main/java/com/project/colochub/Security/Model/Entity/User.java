package com.project.colochub.Security.Model.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.colochub.Models.Entities.House;
import com.project.colochub.Models.Entities.Offer;
import com.project.colochub.Models.Entities.Subscription;
import com.project.colochub.Security.Model.Enums.Role;
import com.project.colochub.Security.Model.Enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "UsersTable")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotBlank(message = "Phone is mandatory")
    private String phone;
    @NotBlank(message = "Adress is mandatory")
    private String address;
    private Date membership_date;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
}

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    //RelationShips
    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private List<House> houses_list;
    @OneToMany(mappedBy = "owner")
    private List<Offer> offers_list;
    @OneToMany(mappedBy = "searcher")
    private List<Subscription> subscriptions_list;
}
