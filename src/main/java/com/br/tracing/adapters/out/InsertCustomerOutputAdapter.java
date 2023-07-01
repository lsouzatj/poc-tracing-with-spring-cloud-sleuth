package com.br.tracing.adapters.out;

import com.br.tracing.adapters.out.repository.CustomerRepository;
import com.br.tracing.adapters.out.repository.entity.CustomerEntity;
import com.br.tracing.application.core.model.Customer;
import com.br.tracing.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerOutputAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        var customerSaved = customerRepository.save(customerEntity);
        BeanUtils.copyProperties(customerSaved, customer);
        return customer;
    }
}
