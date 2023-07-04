package com.br.tracing.application.ports.in;

import com.br.tracing.application.core.model.Customer;

import java.util.Optional;

public interface FindByIdCustomerInputPort {
    Optional<Customer> findById(Long id0);
}
