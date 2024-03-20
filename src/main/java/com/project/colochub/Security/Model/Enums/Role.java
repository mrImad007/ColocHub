package com.project.colochub.Security.Model.Enums;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.project.colochub.Security.Model.Enums.Permission.*;


@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    OWNER_READ,
                    OWNER_UPDATE,
                    OWNER_DELETE,
                    OWNER_CREATE
            )
    ),
    OWNER(
            Set.of(
                    OWNER_READ,
                    OWNER_UPDATE,
                    OWNER_DELETE,
                    OWNER_CREATE
            )
    ),
    SEARCHER(
            Set.of(
                    SEARCHER_READ,
                    SEARCHER_UPDATE,
                    SEARCHER_DELETE,
                    SEARCHER_CREATE
            )
    );



    private final Set<Permission> permissions;



    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
