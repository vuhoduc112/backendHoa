package com.example.hoa.Controller;
import com.example.hoa.Entity.Users;
import com.example.hoa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/getAll")
    ResponseEntity<List<Users>> getAll() {
        List<Users> usersList =  userService.getAll();
        return ResponseEntity.ok().body(usersList);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Optional<Users>> getById(@PathVariable Long id) {
        Optional<Users> users = userService.findById(id);
        if(users.isPresent()){
            return ResponseEntity.ok().body(users);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/getNameOrIdOrEmail/{query}")
    ResponseEntity<List<Users>> findByIdOrNameOrEmail(@PathVariable("query") String query) {
        List<Users> users = userService.findByIdOrNameOrEmail(query);
        return ResponseEntity.ok().body(users);

    }

    @PostMapping("/create")
    ResponseEntity<Users> createUser(@RequestBody Users users){
        Users createUser = userService.createUser(users);
        return ResponseEntity.ok().body(createUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users users) {
        String usernameOfEmail = users.getUsername() != null ? users.getUsername() : users.getEmail();
        Users existingUser = userService.login(usernameOfEmail, users.getPassword());
        if (existingUser != null) {
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Users> updateUser(@RequestBody Users users, @PathVariable Long id){
        Users updateUser = userService.updateUser(users, id);
        if(updateUser!=null){
            return ResponseEntity.ok().body(updateUser);
        }
        else {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Users> deleteUser(@PathVariable Long id){
        Users users = userService.deleteUser(id);
        if(users != null){
            return  ResponseEntity.ok().body(users);
        }
        else {
           return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> requestMap) {
        String email = requestMap.get("email");
        try {
            userService.forgotPassword(email);
            return new ResponseEntity<>("Vui lòng kiểm tra email của bạn để đặt lại mật khẩu.", HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> requestMap) {
        String token = requestMap.get("token");
        String newPassword = requestMap.get("newPassword");
        try {
            userService.updatePassword(token, newPassword);
            return new ResponseEntity<>("Mật khẩu đã được cập nhật thành công.", HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Users users = userService.findByEmail(email);
        if (users!= null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email đã được sử dụng");
        }
        return ResponseEntity.ok().body(users);
    }
}
