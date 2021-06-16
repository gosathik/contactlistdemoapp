package com.galvanize.contactlist.controller;

import com.galvanize.contactlist.domain.Contacts;
import com.galvanize.contactlist.repository.ContactRepository;
import com.galvanize.contactlist.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity createContact(@RequestBody Contacts contacts)
    {
        contactService.createContact(contacts);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<Contacts>> listContactByGivenName(@RequestParam(required = false) String givenName,@RequestParam(required = false) String surname)
    {
        if(givenName!=null && surname==null)
        return new ResponseEntity(contactService.findByGivenName(givenName), HttpStatus.OK);
        else if(givenName!=null && surname!=null)
            return new ResponseEntity(contactService.findByNames(givenName,surname), HttpStatus.OK);
        else
            return new ResponseEntity(contactService.findAllContacts(), HttpStatus.OK);


    }
    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contacts> findContactById(@PathVariable("id") Long id){
        Optional<Contacts> contact=contactService.findContactById(id);
        if(contact.isPresent())
            return new ResponseEntity(contact.get(),HttpStatus.FOUND);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity deleteContactById(@PathVariable("id") Long id){
        contactService.deleteContactById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PatchMapping("/contacts/{id}")
    public ResponseEntity<Contacts> updateContactById(@RequestBody Contacts contacts, @PathVariable("id") Long id){
        Optional<Contacts> contact=contactService.findContactById(id);
        Contacts con=contact.get();
        if(contact.isPresent()){
            con.setGivenName(contacts.getGivenName());
            con.setSurname(contacts.getSurname());
            con.setPhoneNumber(contacts.getPhoneNumber());
           return new ResponseEntity(contactService.updateById(con),HttpStatus.OK);
        }
        return  new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
