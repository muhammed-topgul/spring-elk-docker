package com.mtopgul.customerservice.service;

import com.mtopgul.customerservice.entity.CustomerEntity;
import com.mtopgul.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author muhammed-topgul
 * @since 17/11/2023 10:30
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerEntity> getAllEmployees() {
        return customerRepository.findAll();
    }

    public CustomerEntity getEmployeeById(Long employeeId) {
        return customerRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id :: " + employeeId));
    }

    public CustomerEntity createEmployee(CustomerEntity employee) {
        return customerRepository.save(employee);
    }

    public CustomerEntity updateEmployee(Long employeeId, CustomerEntity employee) {
        CustomerEntity customerEntity = getEmployeeById(employeeId);
        BeanUtils.copyProperties(employee, customerEntity);
        return customerRepository.save(customerEntity);
    }

    public Map<String, Boolean> deleteEmployee(Long employeeId) {
        CustomerEntity customerEntity = getEmployeeById(employeeId);
        customerRepository.delete(customerEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
