package com.project.colochub.Repositories;

import com.project.colochub.Models.Entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
