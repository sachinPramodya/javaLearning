package com.perspicaz.learning.modules.customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Customer findByName(String name);

    Customer findByMobile(String name);


}