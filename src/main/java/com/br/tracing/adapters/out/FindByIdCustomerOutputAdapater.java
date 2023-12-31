package com.br.tracing.adapters.out;

import com.br.tracing.adapters.out.repository.CustomerRepository;
import com.br.tracing.application.core.model.Customer;
import com.br.tracing.application.ports.out.FindByIdOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@Component
@RequiredArgsConstructor
public class FindByIdCustomerOutputAdapater implements FindByIdOutputPort {
    private final CustomerRepository customerRepository;
    @Override
    public Optional<Customer> findById(Long id) {
        log.info("Finding customer by id");
        var optionalCustomerEntity = customerRepository.findById(id);
        if (optionalCustomerEntity.isPresent()){
            Customer customer = new Customer();
            BeanUtils.copyProperties(optionalCustomerEntity.get(), customer);
            log.info("Customer found");
            return Optional.of(customer);
        }
        log.info("Customer not found");
        return Optional.empty();
    }
}
