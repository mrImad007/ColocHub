package com.project.colochub.Security.Model.Repository;

import com.project.colochub.Security.Model.Entity.User;
import com.project.colochub.Security.Model.Enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPhone(String email,String phone);

    List<User> findByStatus(Status status);
}
