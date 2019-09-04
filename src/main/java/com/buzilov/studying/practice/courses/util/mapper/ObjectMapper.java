package com.buzilov.studying.practice.courses.util.mapper;

import org.modelmapper.ModelMapper;

public abstract class ObjectMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    private ObjectMapper() {
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }
}
