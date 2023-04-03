package org.supemir.tp3.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ){
        try {
            Page<Customer> customers = customerService.getCustomersByPage(PageRequest.of(page,size));
            model.addAttribute("customers", customers);
            model.addAttribute("pages", new int[customers.getTotalPages()]);
            model.addAttribute("currentPage",page);
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
        }
        return "customers";
    }
}
