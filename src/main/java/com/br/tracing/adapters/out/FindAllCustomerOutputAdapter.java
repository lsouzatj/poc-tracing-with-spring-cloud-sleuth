package com.br.tracing.adapters.out;

import com.br.tracing.adapters.out.repository.CustomerRepository;
import com.br.tracing.application.core.model.Customer;
import com.br.tracing.application.ports.out.FindAllCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Component
@RequiredArgsConstructor
public class FindAllCustomerOutputAdapter implements FindAllCustomerOutputPort {
    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        log.info("Finding all customers");
        var customerEntityList = customerRepository.findAll();
        List<Customer> customerList =
                customerEntityList.stream()
                        .map(customerEntityStream->{
                            Customer customer = new Customer();
                            BeanUtils.copyProperties(customerEntityStream, customer);
                            return customer;
                        })
                        .collect(Collectors.toList());
        log.info("Customers found");
        return customerList;
    }
}
