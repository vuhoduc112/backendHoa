package com.example.hoa.Service;

import com.example.hoa.Entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> getAll();
    Optional<Users> findById(Long id);
    Users createUser(Users users);
    Users deleteUser(Long id);
    Users updateUser(Users users, Long id);
    Users login(String usernameOfEmail, String password);

    List<Users> findByIdOrNameOrEmail(String query);

    void forgotPassword(String email);

    Users findByEmail(String email);

    void updatePassword(String token, String newPassword);
}
