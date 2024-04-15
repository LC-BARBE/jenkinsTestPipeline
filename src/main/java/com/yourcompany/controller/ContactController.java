package com.yourcompany.controller;

import com.yourcompany.model.Contact;
import com.yourcompany.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String showAddForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add-contact";
    }

    @PostMapping("/contacts")
    public String addContact(@ModelAttribute Contact contact, Model model) {
        contactService.saveContact(contact);
        model.addAttribute("contacts", contactService.findAllContacts());
        return "contacts"; // redirects to the view that lists all contacts
    }

    @GetMapping("/contacts")
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactService.findAllContacts());
        return "contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }
}
