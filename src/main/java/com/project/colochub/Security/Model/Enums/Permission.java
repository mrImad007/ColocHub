package com.project.colochub.Security.Model.Enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    OWNER_READ("owner:read"),
    OWNER_UPDATE("owner:update"),
    OWNER_CREATE("owner:create"),
    OWNER_DELETE("owner:delete"),
    SEARCHER_READ("searcher::read"),
    SEARCHER_UPDATE("searcher::update"),
    SEARCHER_DELETE("searcher::create"),
    SEARCHER_CREATE("searcher::delete"),
    ;

    private final String permission;
}
