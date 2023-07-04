package com.br.tracing.application.ports.in;

import com.br.tracing.application.core.model.Customer;

public interface InsertCustomerInputPort {
    Customer save(Customer customer, String zipCode);
}
