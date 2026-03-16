package com.example.UserReg.repository;

import com.example.UserReg.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

    public interface UserRepository extends JpaRepository<User, Integer> {


        public void registerUser(User user);

       // @Query("SELECT COUNT(u) FROM User u WHERE u.userName = :username")
        boolean existsByUsername(String userName);



        //@Query("SELECT COUNT(u) FROM User u WHERE u.email = :email")
        boolean existsByEmail(String email);

        @Query(" SELECT u.password FROM User u WHERE u.userName = :userNameOrEmail OR u.email = :userNameOrEmail")
        public String getEncodedPassword(String userNameOrEmail);

    }


