package org.supemir.tp3.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findCustomerByEmailContaining(String email);
    List<Customer> findCustomerByEmailContainingAndNameStartingWith(String email,String name);
    @Query("from Customer c where c.name like '%:keyword%'")
    List<Customer> exampleCustomer(String keyword);
}
