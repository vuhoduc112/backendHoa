package com.example.hoa.Repository;

import com.example.hoa.Entity.Orders;
import com.example.hoa.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByUsernameOrEmail(String username, String email);

    @Query("SELECT u FROM Users u WHERE CAST(u.userID AS string) LIKE %:query% OR u.fullname LIKE %:query% OR u.email LIKE %:query%")
    List<Users> findByIdOrNameOrEmail(@Param("query") String query);

    Users findByEmail (String email);

    Users findByResetToken (String resetToken);

}
