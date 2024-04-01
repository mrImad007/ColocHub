package com.project.colochub.Mappers.Maps;

import com.project.colochub.DTO.Response.PhotoDto;
import com.project.colochub.Mappers.Mapper;
import com.project.colochub.Models.Entities.Photo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhotoMapper implements Mapper<Photo, PhotoDto> {
    private final ModelMapper modelMapper;
    public PhotoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public PhotoDto mapTo(Photo photo) {
        return modelMapper.map(photo, PhotoDto.class);
    }

    @Override
    public Photo mapFrom(PhotoDto photoDto) {
        return modelMapper.map(photoDto, Photo.class);
    }
}
