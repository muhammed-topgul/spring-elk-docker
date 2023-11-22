package com.mtopgul.customerservice.init;

import com.mtopgul.customerservice.entity.CustomerEntity;
import com.mtopgul.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author muhammed-topgul
 * @since 17/11/2023 12:52
 */
@Component
@RequiredArgsConstructor
public class InitialData implements CommandLineRunner {
    private final CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        CustomerEntity employee1 = new CustomerEntity();
        employee1.setFirstName("Muhammed");
        employee1.setLastName("Topgul");
        employee1.setEmail("mtopgul@xmail.com");
        customerService.createEmployee(employee1);

        CustomerEntity employee2 = new CustomerEntity();
        employee2.setFirstName("John");
        employee2.setLastName("Doe");
        employee2.setEmail("jdoe@xmail.com");
        customerService.createEmployee(employee2);
    }
}
