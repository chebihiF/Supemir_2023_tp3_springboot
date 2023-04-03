package org.supemir.tp3.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> findCustomers() {
        try {
            // todo: add customized code ...
            return customerService.getCustomers();
        } catch (Exception e) {
            //todo: manage the exception
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        try {
            return customerService.save(customer);
        } catch (Exception e) {
            //todo: manage the exceptions
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable(name = "id") Long id){
        try {
            Customer customer = customerService.getCustomer(id);
            return customerService.delete(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public Customer getByID(@PathVariable(name = "id") Long id){
        try {
            return customerService.getCustomer(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
