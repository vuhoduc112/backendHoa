package com.example.hoa.Controller;

import com.example.hoa.Entity.Contact;
import com.example.hoa.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> contacts = contactService.getAll();
        return ResponseEntity.ok().body(contacts);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Contact>> getById(@PathVariable Long id) {
        Optional<Contact> contacts = contactService.getById(id);
        return ResponseEntity.ok().body(contacts);
    }

    @PostMapping("/create")
    public ResponseEntity<Contact> createContact( @RequestBody  Contact contact) {
        Contact contact1 = contactService.createContact(contact);
        return ResponseEntity.ok().body(contact1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateContact( @RequestBody Contact contact, @PathVariable Long id){
        Contact contact1 = contactService.updateContact(contact, id);
        return ResponseEntity.ok().body(contact1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Contact>> deleteContact(@PathVariable Long id){
        Optional<Contact> contact = contactService.deleteContact(id);
        return ResponseEntity.ok().body(contact);
    }
}
