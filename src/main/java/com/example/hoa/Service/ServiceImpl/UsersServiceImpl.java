package com.example.hoa.Service.ServiceImpl;
import java.util.UUID;
import com.example.hoa.Entity.Users;
import com.example.hoa.Repository.UsersRepository;
import com.example.hoa.Service.EmailService;
import com.example.hoa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    public UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }


    @Override
    public Users deleteUser(Long id) {
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isPresent()){
            usersRepository.deleteById(id);
            return optionalUsers.get();
        }
        else {
            throw new  RuntimeException("not found");
        }
    }

    @Override
    public Users updateUser(Users users, Long id) {
        Users updateUser = usersRepository.findById(id).orElseThrow(() ->  new RuntimeException("not found id"));
        updateUser.setUsername(users.getUsername());
        updateUser.setFullname(users.getFullname());
        updateUser.setPassword(passwordEncoder.encode(users.getPassword()));
        updateUser.setEmail(users.getEmail());
        updateUser.setSdt(users.getSdt());
        updateUser.setRole(users.getRole());
        updateUser.setAddress(users.getAddress());
        updateUser.setNote(users.getNote());
        updateUser.setCompany(updateUser.getCompany());
        updateUser.setZipcode(updateUser.getZipcode());
        return usersRepository.save(updateUser);
    }
    @Override
    public Users createUser(Users users) {
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        return usersRepository.save(users);
    }

    @Override
    public Users login(String usernameOfEmail,  String password) {
        List<Users> existingUsers = usersRepository.findByUsernameOrEmail(usernameOfEmail, usernameOfEmail);
        if (!existingUsers.isEmpty()) {
            Users existingUser = existingUsers.get(0);
            if (passwordEncoder.matches(password, existingUser.getPassword())) {
                return existingUser;
            }
        }
        return null;
    }

    @Override
    public List<Users> findByIdOrNameOrEmail(String query) {
        return usersRepository.findByIdOrNameOrEmail(query);
    }

    @Override
    public void forgotPassword(String email) {
        Users user = usersRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng với email này.");
        }
        String resetToken = UUID.randomUUID().toString();
        user.setResetToken(resetToken);
        usersRepository.save(user);

        String resetUrl = "http://localhost:3000/resetPassword?token=" + resetToken;
        emailService.sendResetPasswordEmail(email, resetUrl);
    }

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public void updatePassword(String token, String newPassword) {
        Users user = usersRepository.findByResetToken(token);
        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng với mã token này.");
        }
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetToken(null);
        usersRepository.save(user);
    }



}
