package org.supemir.tp3.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.cache.ExpressionCacheKey;

import java.util.List;

public interface CustomerService {
    Customer save (Customer customer) throws Exception;
    Customer update (Customer customer) throws Exception;
    Customer delete (Customer customer) throws Exception;
    Customer getCustomer (Long id) throws Exception;
    List<Customer> getCustomers () throws Exception;
    Page<Customer> getCustomersByPage(Pageable pageable) throws Exception;


}
