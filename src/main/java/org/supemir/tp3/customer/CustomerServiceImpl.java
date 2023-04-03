package org.supemir.tp3.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) throws Exception {
        if(
                customer.getName().trim().isEmpty() ||
                customer.getId() == null ||
                !customer.getEmail().contains("@")
        ) throw new RuntimeException("cannot add customer with id : "+ customer.getId());

        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer update(Customer customer) throws Exception {
        if(
                customer.getName().trim().isEmpty() ||
                        customer.getId() == null ||
                        !customer.getEmail().contains("@")
        ) throw new RuntimeException("cannot add customer with id : "+ customer.getId());

        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer delete(Customer customer) throws Exception {
        // todo: implement BL (constraints)
        Customer deletedCustomer = getCustomer(customer.getId());
        // todo : add deleted customer to the deleted DB
        customerRepository.delete(customer);
        return deletedCustomer;
    }

    @Override
    public Customer getCustomer(Long id) throws Exception {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) throw new RuntimeException("customer not found");
        return optionalCustomer.get();
    }

    @Override
    public List<Customer> getCustomers() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getCustomersByPage(Pageable pageable) throws Exception {
        return customerRepository.findAll(pageable);
    }
}
