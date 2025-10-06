package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbooks", path = "addressbooks")
public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {

    AddressBook findById(int id);

}


