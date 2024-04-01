package com.project.colochub.Repositories;

import com.project.colochub.Models.Entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    List<Photo> findByHouseId(Integer houseId);
}
