package com.example.hoa.Service.ServiceImpl;

import com.example.hoa.Entity.Contact;
import com.example.hoa.Repository.ContactRepository;
import com.example.hoa.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact, Long id) {
        Contact contact1 = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy contactID"));
        contact1.setFullname(contact.getFullname());
        contact1.setNumberPhone(contact.getNumberPhone());
        contact1.setDesc(contact.getDesc());
        contactRepository.save(contact1);
        return contact1;
    }

    @Override
    public Optional<Contact> deleteContact(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()){
            contactRepository.deleteById(id);
        }
        return null;
    }
}
