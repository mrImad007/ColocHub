package com.project.colochub.Services;

import com.project.colochub.DTO.Request.SubsriptionReq;
import com.project.colochub.DTO.Response.SubscriptionDto;
import com.project.colochub.Mappers.Mapper;
import com.project.colochub.Models.Entities.Subscriptions;
import com.project.colochub.Repositories.SubscriptionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionsService {
    private final SubscriptionsRepository subscriptionRepo;
    private final Mapper<Subscriptions, SubscriptionDto> subscriptionMapper;

    public SubscriptionsService(SubscriptionsRepository subscriptionRepo, Mapper<Subscriptions, SubscriptionDto> subscriptionMapper) {
        this.subscriptionRepo = subscriptionRepo;
        this.subscriptionMapper = subscriptionMapper;
    }

    public List<SubscriptionDto> getAllSubscriptions(){
        return subscriptionRepo.findAll().stream().map(subscriptionMapper::mapTo).toList();
    }

    public List<SubscriptionDto> getSubscriptionBySearcherId(Integer user_id){
        return subscriptionRepo.findBySearcherId(user_id).stream().map(subscriptionMapper::mapTo).toList();
    }
    public List<SubscriptionDto> getSubscriptionByOfferId(Integer offer_id){
        return subscriptionRepo.findByOfferId(offer_id).stream().map(subscriptionMapper::mapTo).toList();
    }

    public SubscriptionDto addSubscription(SubsriptionReq subscriptionReq){
        if (subscriptionReq != null){
            return subscriptionMapper.mapTo(subscriptionRepo.save(subscriptionReq.toModel()));
        }else {
            throw new RuntimeException("Invalid credentials in the request !");
        }
    }

    public boolean deleteSubscription(Integer subscription_id){
        if (subscription_id > 0){
            if (subscriptionRepo.findById(subscription_id).isPresent()){
                subscriptionRepo.deleteById(subscription_id);
                return true;
            }else {
                throw new RuntimeException("Subscription not found with id : "+subscription_id);
            }
        }else {
            throw new RuntimeException("Invalid subscription id!");
        }
    }
}
