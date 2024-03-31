package com.project.colochub.Repositories;

import com.project.colochub.Models.Entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
