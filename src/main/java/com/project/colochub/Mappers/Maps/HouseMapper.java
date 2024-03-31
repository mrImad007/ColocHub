package com.project.colochub.Mappers.Maps;

import com.project.colochub.DTO.Response.HouseDto;
import com.project.colochub.Mappers.Mapper;
import com.project.colochub.Models.Entities.House;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HouseMapper implements Mapper<House, HouseDto> {
    private final ModelMapper modelMapper;

    public HouseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public HouseDto mapTo(House house) {
        return modelMapper.map(house, HouseDto.class);
    }

    @Override
    public House mapFrom(HouseDto houseDto) {
        return modelMapper.map(houseDto, House.class);
    }
}
