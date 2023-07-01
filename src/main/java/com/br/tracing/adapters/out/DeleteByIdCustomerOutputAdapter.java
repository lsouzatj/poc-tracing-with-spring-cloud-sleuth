package com.br.tracing.adapters.out;

import com.br.tracing.adapters.out.repository.CustomerRepository;
import com.br.tracing.adapters.out.repository.entity.CustomerEntity;
import com.br.tracing.application.core.model.Customer;
import com.br.tracing.application.ports.out.DeleteByIdCustomOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteByIdCustomerOutputAdapter implements DeleteByIdCustomOutputPort {
    private final CustomerRepository customerRepository;
    @Override
    public void delete(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
       customerRepository.delete(customerEntity);
    }
}
