package com.project.colochub.Repositories;

import com.project.colochub.Models.Entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Integer> {
}
