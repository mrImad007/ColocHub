package com.project.colochub.Controllers;

import com.project.colochub.DTO.Request.SubsriptionReq;
import com.project.colochub.DTO.Response.SubscriptionDto;
import com.project.colochub.Services.SubscriptionsService;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subscriptions")
public class SubscriptionController {
    private final SubscriptionsService subscriptionsService;
    public SubscriptionController(SubscriptionsService subscriptionsService) {
        this.subscriptionsService = subscriptionsService;
    }

    @GetMapping
    public List<SubscriptionDto> getAllSubscriptions(){
        return subscriptionsService.getAllSubscriptions();
    }

    @GetMapping("/{searcher_id}")
    public List<SubscriptionDto> getSubscriptionBySearcherId(@PathVariable Integer searcher_id){
        return subscriptionsService.getSubscriptionBySearcherId(searcher_id);
    }
    @GetMapping("/offer/{offer_id}")
    public List<SubscriptionDto> getSubscriptionByOfferId(@PathVariable Integer offer_id){
        return subscriptionsService.getSubscriptionByOfferId(offer_id);
    }

    @PostMapping
    public SubscriptionDto addSubscription(@RequestBody @NotNull SubsriptionReq subscriptionReq){
        return subscriptionsService.addSubscription(subscriptionReq);
    }

    @DeleteMapping("/{subscription_id}")
    public boolean deleteSubscription(@PathVariable Integer subscription_id){
        return subscriptionsService.deleteSubscription(subscription_id);
    }
}
