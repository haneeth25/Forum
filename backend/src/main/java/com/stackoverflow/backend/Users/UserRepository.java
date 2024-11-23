package com.stackoverflow.backend.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserNameAndPassword(String userName, String password);
    UserEntity findByUserName(String userName);
    Integer countByUserName(String userName);

}
