package com.project.colochub.Mappers;

public interface Mapper<Entity, EntityDto> {

    EntityDto mapTo(final Entity entity);
    Entity mapFrom(final EntityDto dto);

}
