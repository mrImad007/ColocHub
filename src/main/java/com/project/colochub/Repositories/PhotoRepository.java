package com.project.colochub.Repositories;

import com.project.colochub.Models.Entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}
