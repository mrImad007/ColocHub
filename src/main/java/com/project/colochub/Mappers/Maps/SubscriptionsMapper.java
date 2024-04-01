package com.project.colochub.Mappers.Maps;

import com.project.colochub.DTO.Response.SubscriptionDto;
import com.project.colochub.Mappers.Mapper;
import com.project.colochub.Models.Entities.Subscriptions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionsMapper implements Mapper<Subscriptions, SubscriptionDto> {
    private final ModelMapper modelMapper;

    public SubscriptionsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SubscriptionDto mapTo(Subscriptions subscriptions) {
        return modelMapper.map(subscriptions, SubscriptionDto.class);
    }

    @Override
    public Subscriptions mapFrom(SubscriptionDto subscriptionDto) {
        return modelMapper.map(subscriptionDto, Subscriptions.class);
    }
}
