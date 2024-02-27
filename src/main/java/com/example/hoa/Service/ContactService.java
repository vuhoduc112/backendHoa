package com.example.hoa.Service;

import com.example.hoa.Entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getAll();

    Optional<Contact> getById(Long id);

    Contact createContact(Contact contact);

    Contact updateContact(Contact contact, Long id);

    Optional<Contact> deleteContact(Long id);
}
