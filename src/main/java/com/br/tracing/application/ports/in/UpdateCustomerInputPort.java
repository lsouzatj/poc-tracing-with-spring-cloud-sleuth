package com.br.tracing.application.ports.in;

import com.br.tracing.application.core.model.Customer;

import java.util.Optional;

public interface UpdateCustomerInputPort {
    Optional<Customer> update(Customer customer, Long id);
}
