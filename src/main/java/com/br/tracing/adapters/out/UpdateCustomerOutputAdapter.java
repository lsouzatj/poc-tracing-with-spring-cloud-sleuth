package com.br.tracing.adapters.out;

import com.br.tracing.adapters.out.repository.CustomerRepository;
import com.br.tracing.adapters.out.repository.entity.CustomerEntity;
import com.br.tracing.application.core.model.Customer;
import com.br.tracing.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@Component
@RequiredArgsConstructor
public class UpdateCustomerOutputAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> update(Customer customer) {
        log.info("Updating customer");
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        var newCustomer = customerRepository.save(customerEntity);
        BeanUtils.copyProperties(newCustomer, customer);
        log.info("Customer updated");
        return Optional.of(customer);
    }
}
