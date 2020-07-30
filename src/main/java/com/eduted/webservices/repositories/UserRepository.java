package com.eduted.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.eduted.webservices.model.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String>
{

}
