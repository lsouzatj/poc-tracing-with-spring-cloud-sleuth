package com.br.tracing.application.ports.out;

import com.br.tracing.application.core.model.Customer;

import java.util.List;

public interface FindAllCustomerOutputPort {
    List<Customer> findAll();
}
