package com.br.tracing.adapters.in.controller;

import com.br.tracing.adapters.in.controller.requestDTO.CustomerRequestDTO;
import com.br.tracing.adapters.in.controller.responseDTO.CustomerResponseDTO;
import com.br.tracing.application.core.model.Customer;
import com.br.tracing.application.ports.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindAllCustomerInputPort findAllCustomerInputPort;
    private final FindByIdCustomerInputPort findByIdCustomerInputPort;
    private final DeleteByIdCustomerInputPort deleteByIdCustomerInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;

    @PostMapping("/save/{zipCode}")
    public ResponseEntity<CustomerResponseDTO> save(@RequestBody CustomerRequestDTO customerRequestDTO,
                                                    @PathVariable("zipCode") String zipCode){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequestDTO, customer);
        var customerSaved = insertCustomerInputPort.save(customer, zipCode);
        return Optional.ofNullable(customerSaved).map((c) ->{
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            BeanUtils.copyProperties(c, customerResponseDTO);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTO);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerResponseDTO>> findAll(){
        List<Customer> listCustomer = findAllCustomerInputPort.findAll();
        if (!listCustomer.isEmpty()){
            List<CustomerResponseDTO> customerResponseList = listCustomer.stream()
                    .map(customer->{
                        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
                        BeanUtils.copyProperties(customer, customerResponseDTO);
                        return customerResponseDTO;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(customerResponseList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable("id") Long id) {
        return findByIdCustomerInputPort.findById(id).map(customer -> {
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            BeanUtils.copyProperties(customer, customerResponseDTO);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTO);
                }
        ).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerResponseDTO> deleteById(@PathVariable("id") Long id){
        return deleteByIdCustomerInputPort.delete(id).map(customer -> {
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            BeanUtils.copyProperties(customer, customerResponseDTO);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTO);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponseDTO> update(@RequestBody CustomerRequestDTO customerRequest, @PathVariable("id") Long id){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        return updateCustomerInputPort.update(customer, id).map(newCustomer ->{
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            BeanUtils.copyProperties(newCustomer, customerResponseDTO);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponseDTO);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
}
