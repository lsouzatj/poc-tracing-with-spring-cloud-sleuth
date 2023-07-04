package com.br.tracing.application.ports.out;

import com.br.tracing.application.core.model.Customer;

import java.util.Optional;

public interface FindByIdOutputPort {
    Optional<Customer> findById(Long id);
}
