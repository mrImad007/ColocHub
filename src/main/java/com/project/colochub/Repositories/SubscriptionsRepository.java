package com.project.colochub.Repositories;

import com.project.colochub.Models.Entities.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Integer> {
    List<Subscriptions> findBySearcherId(Integer userId);
    List<Subscriptions> findByOfferId(Integer userId);
}
