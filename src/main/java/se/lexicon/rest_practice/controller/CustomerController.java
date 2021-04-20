package se.lexicon.rest_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.rest_practice.entity.Customer;
import se.lexicon.rest_practice.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController//**notice in rest u have to use restController not controller
@RequestMapping("/api/customer/")
public class CustomerController {

    CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customerList::add);
        return ResponseEntity.ok(customerList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent())
            return ResponseEntity.ok(optionalCustomer.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")//notice: u have to use deleteMapping not getMapping when u need to delete
    public ResponseEntity<Customer> deleteById(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }


}
