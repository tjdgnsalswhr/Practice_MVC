package com.example.demo.user.core.port_infra.persistent;

import org.springframework.stereotype.Repository;

import com.example.demo.user.core.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
