package com.mtopgul.customerservice.controller;

import com.mtopgul.customerservice.entity.CustomerEntity;
import com.mtopgul.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author muhammed-topgul
 * @since 17/11/2023 10:26
 */
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerEntity> getAllEmployees() {
        return customerService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        return ResponseEntity.ok().body(customerService.getEmployeeById(employeeId));
    }

    @PostMapping
    public CustomerEntity createEmployee(@RequestBody CustomerEntity employee) {
        return customerService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                         @RequestBody CustomerEntity employee) {
        CustomerEntity updatedEmployee = customerService.updateEmployee(employeeId, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        return customerService.deleteEmployee(employeeId);
    }
}
