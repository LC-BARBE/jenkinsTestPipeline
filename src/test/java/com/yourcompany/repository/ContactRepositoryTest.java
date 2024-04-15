package com.yourcompany.repository;

import com.yourcompany.model.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testSaveContact() {
        Contact contact = new Contact("John Doe", "john.doe@example.com", "1234567890", "123 Elm Street");
        Contact savedContact = contactRepository.save(contact);
        assertNotNull(savedContact.getId());
        assertEquals("John Doe", savedContact.getName());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("Jane Doe", "jane.doe@example.com", "1234567890", "124 Elm Street");
        contact = contactRepository.save(contact);
        contactRepository.delete(contact);
        assertTrue(contactRepository.findById(contact.getId()).isEmpty());
    }
}

