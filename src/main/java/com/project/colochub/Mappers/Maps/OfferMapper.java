package com.project.colochub.Mappers.Maps;

import com.project.colochub.DTO.Response.OfferDto;
import com.project.colochub.Mappers.Mapper;
import com.project.colochub.Models.Entities.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper implements Mapper<Offer, OfferDto> {
    private final ModelMapper modelMapper;

    public OfferMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OfferDto mapTo(Offer offer) {
        return modelMapper.map(offer, OfferDto.class);
    }

    @Override
    public Offer mapFrom(OfferDto offerDto) {
        return modelMapper.map(offerDto, Offer.class);
    }
}
