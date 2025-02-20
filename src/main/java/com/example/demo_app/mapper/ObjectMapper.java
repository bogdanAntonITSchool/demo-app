package com.example.demo_app.mapper;

/**
 * This interface is used to map objects from one type to another.
 *
 * @param <D> the dto type
 * @param <E> the entity type
 */
public interface ObjectMapper<D, E> {

    /**
     * Map dto to entity.
     *
     * @param dto the dto
     * @return the entity
     */
    E mapDtoToEntity(D dto);

    /**
     * Map entity to dto.
     *
     * @param entity the entity
     * @return the dto
     */
    D mapEntityToDto(E entity);

}
