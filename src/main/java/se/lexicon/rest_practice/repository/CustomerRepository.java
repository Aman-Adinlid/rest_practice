package se.lexicon.rest_practice.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.rest_practice.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByEmailIgnoreCase(String email);

    List<Customer> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}
