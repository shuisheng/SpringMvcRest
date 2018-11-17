package net.viralpatel.spring.controller;

import net.viralpatel.spring.dao.CustomerDAO;
import net.viralpatel.spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerDAO.list();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {

        Customer customer = customerDAO.get(id);
        if (customer == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
