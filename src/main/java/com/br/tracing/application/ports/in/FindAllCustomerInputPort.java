package com.br.tracing.application.ports.in;

import com.br.tracing.application.core.model.Customer;

import java.util.List;

public interface FindAllCustomerInputPort {
    List<Customer> findAll();
}
