package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    List<AddressBook> findAddressBookByNameOfBook(String bookName);

    AddressBook findById(long l);
}
