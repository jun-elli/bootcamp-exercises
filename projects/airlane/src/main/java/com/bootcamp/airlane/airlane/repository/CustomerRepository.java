package com.bootcamp.airlane.airlane.repository;

import com.bootcamp.airlane.airlane.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
