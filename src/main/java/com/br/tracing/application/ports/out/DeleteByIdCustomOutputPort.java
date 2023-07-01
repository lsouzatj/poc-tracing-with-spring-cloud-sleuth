package com.br.tracing.application.ports.out;

import com.br.tracing.application.core.model.Customer;

public interface DeleteByIdCustomOutputPort {
    void delete(Customer customer);
}
