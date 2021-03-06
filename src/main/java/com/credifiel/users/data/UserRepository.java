package com.credifiel.users.data;

import com.credifiel.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);
//    public <List<User>> FindByFirstNameStartingWith(String firstname);
}
