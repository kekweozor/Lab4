package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressBookController {

    private final AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addressbooks/{id}/view")
    public String viewAddressBook(@PathVariable int id, Model model) {
        AddressBook addressBook = addressBookRepository.findById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Invalid addressbook id: " + id));

        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddies", addressBook.getAddressList());

        return "addressbook-view"; // maps to src/main/resources/templates/addressbook-view.html
    }
}

