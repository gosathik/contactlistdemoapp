package com.galvanize.contactlist.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.galvanize.contactlist.domain.Contacts;
import com.galvanize.contactlist.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;
    public List<Contacts> findAllContacts() {
        return contactRepository.findAll();
    }

    public void createContact(Contacts contacts)
    {
        contactRepository.save(contacts);
    }

    public List<Contacts> findByGivenName(String givenName) {
        return contactRepository.findByGivenName(givenName);
    }

    public List<Contacts> findByNames(String givenName, String surname) {
        return contactRepository.findByNames(givenName,surname);
    }

    public Optional<Contacts> findContactById(Long id) {
        return contactRepository.findById(id);
    }

    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }
    public Contacts updateById(Contacts contact){
        return contactRepository.save(contact);
    }
}
