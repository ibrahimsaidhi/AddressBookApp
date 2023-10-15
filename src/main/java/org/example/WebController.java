package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    private AddressBookRepository repository;
    private BuddyInfoRepository infoRepository;
    @Autowired
    public WebController(AddressBookRepository repository, BuddyInfoRepository infoRepository){
        this.repository = repository;
        this.infoRepository = infoRepository;
    }

    @PostMapping(path = "addressBooks")
    public ResponseEntity<AddressBook> createAddressBook(@RequestBody AddressBook book){
        AddressBook book1 = repository.save(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @PutMapping("/addressBooks/{address_id}/buddies/{buddy_id}")
    public AddressBook putBuddyInfo(@PathVariable long address_id, @PathVariable long buddy_id){
        AddressBook book = repository.findById(address_id);
        BuddyInfo info = infoRepository.findById(buddy_id);
        book.addBuddyInfo(info);
        return repository.save(book);
    }

    @GetMapping
    public String displayAddressBook(Model model){
        model.addAttribute("book", repository.findById(1L));
        return "book";
    }


}
