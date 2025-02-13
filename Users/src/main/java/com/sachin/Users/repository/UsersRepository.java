package com.sachin.Users.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sachin.Users.model.UsersTBL;

@Repository
public interface UsersRepository extends JpaRepository<UsersTBL, Long>
{
}