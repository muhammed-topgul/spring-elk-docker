package com.mtopgul.customerservice.repository;

import com.mtopgul.customerservice.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author muhammed-topgul
 * @since 17/11/2023 10:31
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
